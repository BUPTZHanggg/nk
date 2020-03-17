package binaryTree;

public class MirrorOfBT {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        Mirror(left);
        Mirror(right);
        root.left = right;
        root.right = left;
    }

}
