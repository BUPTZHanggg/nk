package bst;

import binaryTree.TreeNode;

import java.util.ArrayList;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
public class ConvertBSTToLinkedList {

//--------------------------------------------------------------------

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return  null;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        addToList(pRootOfTree, list);
        TreeNode cur = list.get(0);
        TreeNode pre = null;
        TreeNode next = null;
        //遍历集合，得到双向链表
        for (int i = 0;i < list.size();i++){
            next = (i + 1 == list.size()) ? null : list.get(i + 1);
            cur.left = pre;
            cur.right = next;
            pre = cur;
            cur = next;
        }
        return  list.get(0);
    }

    /**
     * 中序遍历，把树的元素递增地放到集合中
     * @param root
     * @param list
     */
    public void addToList(TreeNode root, ArrayList<TreeNode> list){
        if (root == null) return;
        addToList(root.left,list);
        list.add(root);
        addToList(root.right, list);
    }

    //-----------------------------------------------------------------------
}

