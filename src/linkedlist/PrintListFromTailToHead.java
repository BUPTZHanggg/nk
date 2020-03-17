package linkedlist;

import org.junit.Test;

import java.util.ArrayList;

public class PrintListFromTailToHead {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(printListFromTailToHead2(n1));
    }

    //---------------------------------------------------------------------

    /**
     * 方法一
     * 两个指针分别指当前节点和上一个节点
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode == null)
            return res;
        ListNode next = null;
        ListNode pre = null;
        while (listNode != null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        while (pre != null){
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }

    //----------------------------------------------------------

    ArrayList<Integer> res = new ArrayList<Integer>();

    /**
     * 方法二：
     * 深入理解递归思想
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null)
            return res;
        if (listNode.next != null){
            printListFromTailToHead2(listNode.next);
        }
        res.add(listNode.val);
        return res;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
