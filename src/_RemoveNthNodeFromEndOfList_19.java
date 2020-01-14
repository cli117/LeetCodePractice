public class _RemoveNthNodeFromEndOfList_19 {

    private static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        for (int i = 0; i < n; i++)
        {
            if (ptr1 != null)
            {
                ptr1 = ptr1.next;
            }
        }

        if (ptr1 == null)
        {
            head = head.next;
            return head;
        }
        while (ptr1.next != null)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2.next = ptr2.next.next;
        return head;
    }
}

// Two pointers, move the first n times then move the second
// and the ListNode after the second point will be deleted.
