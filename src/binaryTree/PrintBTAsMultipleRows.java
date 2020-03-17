package binaryTree;

import org.junit.Test;

import java.util.ArrayList;

public class PrintBTAsMultipleRows {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(Print(t1));

    }


//============================================================================


    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> queue1 = new ArrayList<TreeNode>();
        if (pRoot != null)
            queue1.add(pRoot);
        ArrayList<TreeNode> queue2 = new ArrayList<TreeNode>();
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (queue2.isEmpty()){
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!queue1.isEmpty()){
                    TreeNode node = queue1.remove(0);
                    list.add(node.val);
                    if (node.left != null)
                        queue2.add(node.left);
                    if (node.right != null)
                        queue2.add(node.right);
                }
                res.add(list);
            }else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!queue2.isEmpty()){
                    TreeNode node = queue2.remove(0);
                    list.add(node.val);
                    if (node.left != null)
                        queue1.add(node.left);
                    if (node.right != null)
                        queue1.add(node.right);
                }
                res.add(list);
            }
        }
        return res;
    }


    //=============================================================


    //递归
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int depth = 1;
        printHelper(pRoot,depth,res);
        return res;
    }

    private void printHelper(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> res) {
        if (pRoot == null);
        if (depth > res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth - 1).add(pRoot.val);

        printHelper(pRoot.left,depth + 1,res);
        printHelper(pRoot.right,depth + 1,res);
    }


}
