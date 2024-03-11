package T234回文链表;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode head1=new ListNode();
        ListNode head2=new ListNode();
        ListNode head3=new ListNode();
        ListNode head4=new ListNode();
        head.next=head1;
        head.val=0;
        head1.next=head2;
        head1.val=1;
        head2.next=head3;
        head2.val=2;
//        head3.next=head4;
        head3.val=3;
        head4.val=4;
//        ListNode a =new Solution().isPalindrome(head);
//        System.out.println(a.val);
        //0 1 2 3 4
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while ( fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
        }
        //当链表的长度为奇数时，fast!=null
        if(fast != null){
            slow=slow.next;
        }
        //反转slow
        slow=reverseList(slow);

        while (slow != null){
            if(head.val != slow.val){
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }

    ListNode reversal(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        if(head ==  null || head.next == null ) return head;
        ListNode newHead =reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
