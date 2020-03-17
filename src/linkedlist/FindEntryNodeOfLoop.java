package linkedlist;

import org.junit.Ignore;
import org.junit.Test;

public class FindEntryNodeOfLoop {

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(EntryNodeOfLoop(n1) == n2);
    }

    /**
     *
     * 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
     * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
     * 可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (true){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == null || p2 == null) return null;
            if (p1 == p2)
                break;
        }
        p1 = pHead;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
