package binaryTree;

//输入一棵二叉树，判断该二叉树是否是平衡二叉树
public class IsBalanced {

    //------------------------------------------------------------------------------

    /**
     * 思路一
     * 运用递归，判断左右子树深度差是否满足平衡，若满足再判断左右子树是否都是平衡树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null) return true;
        int leftTreeDepth = depth1(root.left);
        int rightTreeDepth = depth1(root.right);
        if (Math.abs(leftTreeDepth - rightTreeDepth) <= 1)
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        return false;
    }

    public int depth1(TreeNode root){
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //------------------------------------------------------------------------------------

    /**
     * 思路二（更好的解法）
     * 同样运用递归，若某子树不满足平衡要求，一路返回-1
     * 在主函数中判断树的深度是否为-1即可
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = depth1(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth1(root.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }else {
            return Math.max(leftDepth,rightDepth) + 1;
        }
    }

    //----------------------------------------------------------------

}
