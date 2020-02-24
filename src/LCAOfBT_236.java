import java.util.*;

public class LCAOfBT_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recursion
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        TreeNode result = new TreeNode(-1);
//        recursion(root, p, q, result);
//        return result;
//    }
//
//    private boolean recursion(TreeNode current, TreeNode p, TreeNode q, TreeNode result)
//    {
//        if (current == null) return false;
//
//        int left = recursion(current.left, p, q, result) ? 1 : 0;
//
//        int right = recursion(current.right, p, q, result) ? 1 : 0;
//
//        int mid = (current == p || current == q) ? 1 : 0;
//
//        if (mid + left + right > 1) result.val = current.val;
//
//        return (left + mid + right > 0);
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> descendantNAncestor = new HashMap<>();
        Deque<TreeNode> ite = new ArrayDeque<>();
        descendantNAncestor.put(root, null);
        ite.push(root);

        while (!(descendantNAncestor.containsKey(p) && descendantNAncestor.containsKey(q)))
        {
            TreeNode node = ite.pop();

            if (node.left != null)
            {
                descendantNAncestor.put(node.left, node);
                ite.push(node.left);
            }

            if (node.right != null)
            {
                descendantNAncestor.put(node.right, node);
                ite.push(node.right);
            }
        }

        HashSet<TreeNode> ancestors = new HashSet<>();

        while (p != null)
        {
            ancestors.add(p);
            p = descendantNAncestor.get(p);
        }

        while (q != null)
        {
            if (ancestors.contains(q)) return q;
            q = descendantNAncestor.get(q);
        }
        return null;
    }
}
