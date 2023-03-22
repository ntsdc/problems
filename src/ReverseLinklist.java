import ds.List2String;
import ds.ListNode;
import ds.String2Array;

import java.util.List;

public class ReverseLinklist {

    public static void main(String[] args) {
        System.out.println(String2Array.listNodeToString(
                new Solution206().reverseList(
                String2Array.stringToListNode("[2,1]")
        )));

    }

}
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        in(head);
        return tail;

    }

    public void in(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        in(head.next);

        if(head.next.next == null){
            head.next.next = head;
            head.next = null;
        }

    }
}

class Solution206_ {//官方题解 逻辑清晰代码少
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
