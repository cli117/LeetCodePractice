package PCRecursion;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _DiameterOfBT_543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        // Diameter = # nodes - 1
        return ans - 1;
    }

    private int depth(TreeNode node)
    {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
