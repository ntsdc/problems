import ds.ListNode;
import ds.String2Array;

public class LinklistIsPalindrome {
    public static void main(String[] args) {
        System.out.println(
                new Solution234().isPalindrome(
                        String2Array.stringToListNode("[1,3,4,4,3,1]")
                )
        );
    }
}
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        ListNode slow = head, fast = head;
        while (true){
            if(fast.next == null){
                break;
            }
            if(fast.next.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow, next;
        slow = slow.next;
        pre.next = null;
        while (slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode tail = pre;
        while (head != null){
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}