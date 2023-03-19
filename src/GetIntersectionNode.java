import ds.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {


}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        while (true) {
            if (headA != null) {
                if (hashSet.contains(headA)) {
                    return headA;
                }
                hashSet.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (hashSet.contains(headB)) {
                    return headB;
                }
                hashSet.add(headB);
                headB = headB.next;
            }
            if (headA == null && headB == null) {
                return null;
            }
        }
    }

    public ListNode getIntersectionNode_new(ListNode headA, ListNode headB) {//优化版
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}