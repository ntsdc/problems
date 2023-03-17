import ds.ListNode;
import ds.String2Array;

public class SortList {

    public static void main(String[] args) {

        System.out.println(

                String2Array.listNodeToString(
                        new Solution148().sortList(
                                String2Array.stringToListNode(
                                        "[4,2,1,3]"
                                )
                )


        ));


    }

}

//reuse of solution 21
class Solution148 {

    public ListNode sortList(ListNode head){
        return sortList(head, null);
    }


    public ListNode sortList(ListNode head, ListNode tail) {
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;

        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);

        return new Solution21().mergeTwoLists(left, right);

    }
}