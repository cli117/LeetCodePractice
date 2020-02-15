public class ValidateBST_98 {
    private class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // Note: Nodes need to compare the whole subtree, not only its 2 children
    // So keep track of lower and upper
    public boolean helper(TreeNode node, Integer lower, Integer upper)
    {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root)
    {
        return helper(root, null, null);
    }
}
