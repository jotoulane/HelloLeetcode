package T141环形链表;

import java.util.HashSet;
import java.util.Set;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen =new HashSet<ListNode>();
        while(head!=null){
            if(!seen.add(head)) {
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
