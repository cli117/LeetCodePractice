import java.util.Hashtable;

public class _LRUCache_146_IMPORTANT {
    class LRUCache
    {
        DLinkedListNode head, tail;
        int size, capacity;
        private class DLinkedListNode
        {
            int key;
            int value;
            DLinkedListNode prev;
            DLinkedListNode next;
        }

        Hashtable<Integer, DLinkedListNode> cache = new Hashtable<>();

        private void addNode(DLinkedListNode node)
        {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedListNode node)
        {
            DLinkedListNode temp = node.next;
            node.next.prev = node.prev;
            node.prev.next = temp;
        }

        private void moveToHead(DLinkedListNode node)
        {
            removeNode(node);
            addNode(node);
        }

        private DLinkedListNode popTail()
        {
            DLinkedListNode pop = tail.prev;
            tail.prev = pop.prev;
            tail.prev.next = tail;
            return pop;
        }

        public LRUCache(int capacity)
        {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedListNode();
            tail = new DLinkedListNode();

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key)
        {
            DLinkedListNode node = cache.get(key);
            if (node == null) return -1;

            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value)
        {
            DLinkedListNode node = cache.get(key);
            if (node != null)
            {
                node.value = value;
                moveToHead(node);
                return;
            }

            DLinkedListNode newNode = new DLinkedListNode();
            newNode.value = value;
            newNode.key = key;

            addNode(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity)
            {
                DLinkedListNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }
}
