package T148排序链表;

public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null ){
            return head;
        }
        ListNode fast = head.next, slow = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h=new ListNode(0);
        ListNode res=h;
        while(left != null && right != null){
            if(left.val< right.val){
                h.next=left;
                left= left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        if(left!=null){
            h.next=left;
        }else {
            h.next=right;
        }
        return res.next;
    }
}
