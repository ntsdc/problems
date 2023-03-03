import ds.ListNode;

public class removeNthFromEnd {
    public static void main(String[] args) {

    }

}
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node_fast_n = head, node_slow = new ListNode(0,head), temp = node_slow;
        //temp节点防空指针
        for (int i = 0; i < n; i++) {
            node_fast_n = node_fast_n.next;
        }
        while(node_fast_n != null){
            node_fast_n = node_fast_n.next;
            node_slow = node_slow.next;
        }
        node_slow.next = node_slow.next.next;
        return temp.next;

    }
}