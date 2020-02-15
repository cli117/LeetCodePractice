package PCRecursion;

public class MaxDepthOfBinaryTree_104 {
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // Note: begin with 1 !
        helper(root, 1);
        return max;
    }

    private void helper(TreeNode node, int level)
    {
        if (node == null) return;
        if (level > max) max = level;
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
}
