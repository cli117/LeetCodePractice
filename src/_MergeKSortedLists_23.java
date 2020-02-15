import java.util.PriorityQueue;

public class _MergeKSortedLists_23 {
    public static class ListNode implements Comparable<ListNode>
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }

        public int compareTo(ListNode b)
        {
            if (this.val > b.val) return 1;
            else if (this.val < b.val) return -1;
            else return 0;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists)
    {
        // O(kN), each time do comparison(O(k)) and do N times
//        if (lists.length == 0) return null;
//        ListNode result = new ListNode(-1);
//        ListNode ptr = result;
//        ListNode prev = ptr;
//        while (true)
//        {
//            int smallestIndex = -1;
//            int smallestValue = Integer.MAX_VALUE;
//            for (int i = 0; i < lists.length; i++)
//            {
//                if (lists[i] != null && lists[i].val < smallestValue)
//                {
//                    smallestValue = lists[i].val;
//                    smallestIndex = i;
//                }
//            }
//
//            if(smallestIndex != -1)
//            {
//                ptr.val = smallestValue;
//                ptr.next = new ListNode(-1);
//                prev = ptr;
//                ptr = ptr.next;
//                lists[smallestIndex] = lists[smallestIndex].next;
//            }
//
//            boolean isDone = true;
//            for (int i = 0; i < lists.length; i++)
//            {
//                if (lists[i] != null)
//                {
//                    isDone = false;
//                    break;
//                }
//            }
//            if (isDone)
//            {
//                if (prev.next == null)
//                {
//                    result = null;
//                }
//                if (prev != null)
//                {
//                    prev.next = null;
//                }
//                break;
//            }
//        }
//        return result;




        // Only need k elements in a priority queue at a time, so the comparison would take less time
        // From O(k) to O(logk)
        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                listNodePriorityQueue.add(lists[i]);
            }
        }

        int num = listNodePriorityQueue.size();
        if (num == 0) return null;

        // Every time we have a new node to add, we allocate a new node
        // And we set result to result.next for correctness
        // So we dont have to keep track of the prev
        ListNode result = new ListNode(-1);
        ListNode ptr = result;

        while (listNodePriorityQueue.size() > 0)
        {
            ptr.next = new ListNode(-1);
            ptr = ptr.next;
            ListNode currentNode = listNodePriorityQueue.poll();
            ptr.val = currentNode.val;

            if (currentNode.next != null)
            {
                listNodePriorityQueue.add(currentNode.next);
            }
        }
        result = result.next;
        return result;
    }
}
