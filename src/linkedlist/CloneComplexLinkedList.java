package linkedlist;

public class CloneComplexLinkedList {

    /*
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode clone = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = clone;
            clone.next = next;
            cur = next;
        }
        cur = pHead;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode res = cur.next;
        while (cur != null){
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            cur = cur.next;
        }
        return res;
    }

}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
