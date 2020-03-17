package binaryTree;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPathWithCertainSumInBT {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(6);
        t1.left = t5;
        t1.right = t3;
        t5.left = t2;
        t5.right = t4;
        t3.left = t6;
        t3.right = t7;
        System.out.println(FindPath(t1,17));
    }

//-----------------------------------------------------------------------------------

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null)
            return res;
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return res;
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }

    //----------------------------------------------------------------------------

}
