package PCRecursion;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BTLevelOrderTraversal_102 {
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level)
    {
        if (result.size() == level)
        {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        if (root.left != null)
        {
            helper(root.left, level + 1);
        }

        if (root.right != null)
        {
            helper(root.right, level + 1);
        }
    }
}
