import binaryTree.TreeNode;

import java.util.ArrayList;

public class FindKthNodeInBST {

    private ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

    TreeNode KthNode(TreeNode pRoot, int k){
        inOrder(pRoot);
        if (k <= 0 || nodes.size() < k) return null;
        return nodes.get(k - 1);
    }

    private void inOrder(TreeNode pRoot) {
        if (pRoot == null) return;

        inOrder(pRoot.left);
        nodes.add(pRoot);
        inOrder(pRoot.right);
    }
}
