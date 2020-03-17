package linkedlist;

import org.junit.Test;

//输入两个链表，找出它们的第一个公共结点
public class FindFirstCommonNode {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.next = l6;
        l3.next = l4;
        l1.next = l2;
        l2.next = l3;
        System.out.println(FindFirstCommonNode(l3, l5));
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int len1 = 0;
        ListNode cur1 = pHead1;
        int len2 = 0;
        ListNode cur2 = pHead2;
        while (cur1 != null){
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            len2++;
            cur2 = cur2.next;
        }
        if (len1 <= len2){
            int len = len2 - len1;
            while (len > 0){
                pHead2 = pHead2.next;
                len--;
            }
        }else {
            int len = len1 - len2;
            while (len > 0){
                pHead1 = pHead1.next;
                len--;
            }
        }
        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

}
