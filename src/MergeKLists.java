import ds.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {


}

class Solution23 {
    static class Status implements Comparable<Status>{

        int val;
        ListNode ptr;
        Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }
        public int compareTo(Status status2) {
            return this.val-status2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Status> minheap = new PriorityQueue<>();

        for (ListNode node:lists) {
            if(node != null){
                minheap.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!minheap.isEmpty()){
            Status s = minheap.poll();
            tail.next = s.ptr;
            tail = tail.next;

            if(s.ptr.next != null){
                minheap.offer(new Status(s.ptr.next.val, s.ptr.next));
            }
        }
        return head.next;
    }
}