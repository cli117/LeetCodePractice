package LCDP;

import java.util.HashMap;
import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _HouseRobberIII_337 {
    HashMap<TreeNode, Integer> hashSet = new HashMap<>();
    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return root.val;
//        if (hashSet.containsKey(root)) return hashSet.get(root);
//        int max = 0;
//        if (root.left != null && root.right != null)
//        {
//            max = Math.max(rob(root.left) + rob(root.right), rob(root.left.left) + rob(root.left.right) +
//                    rob(root.right.left) + rob(root.right.right) + root.val);
//        }
//        else if (root.left == null)
//        {
//            max = Math.max(rob(root.left) + rob(root.right), rob(root.right.left) + rob(root.right.right) + root.val);
//        }
//        else
//        {
//            max = Math.max(rob(root.left) + rob(root.right), rob(root.left.left) + rob(root.left.right) + root.val);
//        }
//        hashSet.put(root, max);
//        return max;
        int[] result = StateSolution(root);
        return Math.max(result[0], result[1]);
    }

    // 0 indicates that we decide not to rob the current node
    // 1 indicates we rob it
    private int[] StateSolution(TreeNode node)
    {
        if (node == null) return new int[2];
        int[] result = new int[2];

        int[] left = StateSolution(node.left);
        int[] right = StateSolution(node.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;

        return result;
    }
}
