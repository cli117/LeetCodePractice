public class _PalindromeLinkedList_234_Combination {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = findMid(head);
        ListNode secondHalf = reverse(firstHalfEnd.next);
        ListNode h1 = head, h2 = secondHalf;
        while (h1 != null && h2 != null)
        {
            if (h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // TODO: Remember this, efficient way to reverse a linked list.
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head;
        while (curr != null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
