import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII_142 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> hashset = new HashSet<>();
//        ListNode ite = head;
//        while (ite != null)
//        {
//            if (hashset.contains(ite)) return ite;
//            hashset.add(ite);
//            ite = ite.next;
//        }
//        return null;
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
