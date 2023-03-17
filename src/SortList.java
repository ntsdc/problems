import ds.ListNode;

public class SortList {

    public static void main(String[] args) {

    }

}

//reuse of solution 21
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightStart);

        return new Solution21().mergeTwoLists(left, right);


    }
}