package T206反转链表;


public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head ==  null || head.next == null ) return head;
            ListNode newHead =reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return newHead;
        }
    }
}
