public class _SortList_148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
// TODO: Analyze this!
    public ListNode sortList(ListNode head)
    {
        if (head == null) return null;
        ListNode ptr = head;
        int length = 0;
        while (ptr != null)
        {
            length++;
            ptr = ptr.next;
        }

        ListNode res = new ListNode(0);
        res.next = head;

        for (int j = 1; j < length; j*=2)
        {
            ListNode pre = res;
            ptr = res.next;
            while (ptr != null)
            {
                ListNode h1 = ptr;
                int i = j;
                while (i > 0 && ptr != null)
                {
                    ptr = ptr.next;
                    i--;
                }
                if (i > 0) break; // prt == null triggered the exit of the while loop
                ListNode h2 = ptr;
                i = j;
                while (i > 0 && ptr != null)
                {
                    ptr = ptr.next;
                    i--;
                }

                int c1 = j, c2 = j-i;

                while (c1 > 0 && c2 > 0)
                {
                    if (h1.val < h2.val)
                    {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    }
                    else
                    {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                if (c1 > 0) pre.next = h1;
                else pre.next = h2;
                while (c1 > 0 || c2 > 0)
                {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = ptr;

            }
        }
        return res.next;
    }
}
