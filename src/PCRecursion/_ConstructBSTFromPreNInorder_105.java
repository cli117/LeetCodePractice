package PCRecursion;

import java.util.Map;
import java.util.HashMap;

public class _ConstructBSTFromPreNInorder_105 {
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int pre_index = 0;
    int[] preorder, inorder;
    HashMap<Integer, Integer> in_index = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++)
        {
            in_index.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right)
    {
        if (in_left == in_right) return null;
        int root_val = preorder[pre_index++];
        TreeNode root = new TreeNode(root_val);

        int split = in_index.get(root_val);
        root.left = helper(in_left, split);
        root.right = helper(split + 1, in_right);
        return root;
    }
}
