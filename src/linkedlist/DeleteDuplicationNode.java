package linkedlist;

import org.junit.Test;

import java.util.ArrayList;

public class DeleteDuplicationNode {

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
//        n6.next = n7;

        ListNode n = deleteDuplication(n1);
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    //递归
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        if (pHead.val == pHead.next.val){
            ListNode cur = pHead.next.next;
            while (cur != null && cur.val == pHead.val){
                cur = cur.next;
            }
            return deleteDuplication(cur);
        }else {
            ListNode cur = pHead.next;
            pHead.next = deleteDuplication(cur);
            return pHead;
        }
    }
}

