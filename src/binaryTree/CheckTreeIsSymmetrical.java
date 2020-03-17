package binaryTree;

import binaryTree.TreeNode;
import org.junit.Test;

public class CheckTreeIsSymmetrical {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        System.out.println(isSymmetrical(t1));
    }

    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null) return true;
        return checkMirror(pRoot.left,pRoot.right);
    }

    public boolean checkMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left != null && right != null){
            return left.val == right.val && checkMirror(left.left,right.right) && checkMirror(left.right,right.left);
        }
        return false;
    }
}
