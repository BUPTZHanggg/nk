package binaryTree;

import org.junit.Test;

import java.util.ArrayList;

public class GetNextTreeNode {

    @Test
    public void test(){
        TreeLinkNode n1 = new TreeLinkNode(100);
        TreeLinkNode n2 = new TreeLinkNode(50);
        TreeLinkNode n3 = new TreeLinkNode(70);
        n1.left = n2;
        n1.right = n3;
        n2.next = n1;
        n3.next = n1;
        TreeLinkNode n4 = new TreeLinkNode(60);
        TreeLinkNode n5 = new TreeLinkNode(40);
        TreeLinkNode n6 = new TreeLinkNode(30);
        n2.left = n4;
        n2.right = n5;
        n4.next = n2;
        n5.next = n2;
        n3.left = n6;
        n6.next = n3;
        System.out.println(GetNext(n5) == n1);
    }
    // ===========================================================================
    private ArrayList<TreeLinkNode> linkNodes = new ArrayList<TreeLinkNode>();

    public TreeLinkNode GetNext1(TreeLinkNode pNode){
        TreeLinkNode root = findRoot(pNode);
        afterOrder(root);
        for (int i = 0;i < linkNodes.size();i++){
            if (linkNodes.get(i) == pNode){
                if (i == linkNodes.size() - 1) return null;
                return linkNodes.get(i + 1);
            }
        }
        return null;
    }

    private void afterOrder(TreeLinkNode root) {
        if (root == null) return;
        afterOrder(root.left);
        linkNodes.add(root);
        afterOrder(root.right);
    }

    private TreeLinkNode findRoot(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        while (root != null && root.next != null){
            root = root.next;
        }
        return root;
    }

    //=======================================================================

    //分析二叉树的下一个节点，一共有以下情况：
    //1.二叉树为空，则返回空；
    //2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
    //3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) return null;
        if (pNode.right != null){
            TreeLinkNode cur = pNode.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else {
            if (pNode.next == null) return null;
            TreeLinkNode father = pNode.next;
            if (father.left == pNode) return father;
            TreeLinkNode cur = pNode;
            while (father != null && father.left != cur){
                cur = father;
                father = father.next;
            }
            return father;
        }
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
