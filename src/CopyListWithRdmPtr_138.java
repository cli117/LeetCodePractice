import java.util.ArrayList;
import java.util.List;

public class CopyListWithRdmPtr_138 {
    class Node
    {
        int val;
        Node next;
        Node random;

        public Node(int val)
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head)
    {
        if (head == null) return null;

        Node ite = head;
        while (ite != null)
        {
            Node newNode = new Node(ite.val);
            newNode.next = ite.next;
            ite.next = newNode;
            ite = newNode.next;
        }

        ite = head;
        while (ite != null)
        {
            if (ite.random != null)
            {
                ite.next.random = ite.random.next;
            }
            ite = ite.next.next;
        }

        ite = head;
        Node result = head.next;
        while (ite.next.next != null)
        {
            Node temp = ite.next.next;
            ite.next.next = ite.next.next.next;
            ite.next = temp;
            ite = ite.next;
        }
        ite.next = null;
        return result;
    }
}
