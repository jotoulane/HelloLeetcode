package T24两两交换链表中的节点;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode move = listNode;
        listNode.next=head;
        while (head != null && head.next != null) {
            ListNode n = head.next;
            head.next=head.next.next;
            n.next=head;
            move.next=n;
            move=move.next.next;
            head=n.next.next;
        }
        return listNode.next;
    }
}
