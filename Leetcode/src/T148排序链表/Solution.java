package T148排序链表;
//https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
public class Solution {
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
        ListNode list = mergeTwoLists(left, right);
        return list;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }else if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
