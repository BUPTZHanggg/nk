package binaryTree;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class CheckSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean res = false;
        if (root1.val == root2.val){
            res = check(root1,root2);
        }
        if (!res){
            res = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return res;
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val)
            return false;
        return check(root1.left,root2.left) && check(root1.right, root2.right);
    }
}
