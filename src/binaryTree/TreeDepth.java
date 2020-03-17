package binaryTree;

//输入一棵二叉树，求该树的深度
// 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
public class TreeDepth {

    /**
     * 运用递归
     * @param root
     * @return
     */
    public int TreePath(TreeNode root){
        if (root == null) return 0;
        int leftDepth = TreePath(root.left);
        int rightDepth = TreePath(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }

}
