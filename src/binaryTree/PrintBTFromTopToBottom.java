package binaryTree;

import org.junit.Test;
import sun.misc.Queue;

import java.util.ArrayList;

public class PrintBTFromTopToBottom {

    @Test
    public void test() {
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
//        t3.left = t6;
        t3.right = t7;
        System.out.println(PrintFromTopToBottom(t1));
    }

    //------------------------------------------------------------------

    /**
     * 思路是用ArrayList模拟一个队列来存储相应的TreeNode
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove(0);
            res.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return res;
    }

    //----------------------------------------------------------------------

}
