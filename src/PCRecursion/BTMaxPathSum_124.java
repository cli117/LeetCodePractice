package PCRecursion;

public class BTMaxPathSum_124 {
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        if (root == null) return 0;
        maxVal(root);
        return max_sum;
    }

    private int maxVal(TreeNode node)
    {
        if (node == null) return 0;
        int left_val = Math.max(0, maxVal(node.left));
        int right_val = Math.max(0, maxVal(node.right));
        int path = left_val + right_val + node.val;
        max_sum = Math.max(max_sum, path);
        return node.val + Math.max(left_val, right_val);
    }

//    public int maxPathSum(TreeNode root)
//    {
//        if (root == null) return 0;
//        return maxVal(root);
//    }
//
//    private int maxVal(TreeNode node)
//    {
//        if (node == null) return 0;
//        if (node.left == null && node.right == null) return node.val;
//        if (node.left != null && node.right == null)
//        {
//            return node.val + maxVal(node.left);
//        }
//        if (node.left == null)
//        {
//            return node.val + maxVal(node.right);
//        }
//        return Math.max(Math.max(node.val + maxVal(node.left) + maxVal(node.right), maxVal(node.left)), maxVal(node.right));
//    }
}
