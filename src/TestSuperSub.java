import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}



public class TestSuperSub{
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = pHead;
        ListNode pre = tmpHead, curr = pre.next;
        while (curr != null)
        {
            if (curr.next != null && curr.val == curr.next.val)
            {

                while (curr.next != null && curr.next.val == curr.val)
                    curr = curr.next;
                pre.next = curr.next;
                curr = curr.next;
            }
            else
            {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return tmpHead.next;
    }
}
