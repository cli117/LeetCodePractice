public class MergeTwoSortedList_21 {
    private static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode() { this.val = -1; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null) return null;
        ListNode result = new ListNode(-1);
        ListNode ptr = result;
        ListNode prev = ptr;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                ptr.val = l1.val;
                l1 = l1.next;
            }
            else
            {
                ptr.val = l2.val;
                l2 = l2.next;
            }
            ptr.next = new ListNode(-1);
            prev = ptr;
            ptr = ptr.next;
        }

        while (l1 != null)
        {
            ptr.val = l1.val;
            l1 = l1.next;
            ptr.next = new ListNode(-1);
            prev = ptr;
            ptr = ptr.next;
        }

        while (l2 != null)
        {
            ptr.val = l2.val;
            l2 = l2.next;
            ptr.next = new ListNode(-1);
            prev = ptr;
            ptr = ptr.next;
        }

        prev.next = null;
        return result;
    }
}
