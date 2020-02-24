public class _IntersectionOfTwoLL_160_CLEVERSOL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 都跑到结尾在另一边重新开始后 长度差就抵消掉了。也就会在相交点汇合
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
