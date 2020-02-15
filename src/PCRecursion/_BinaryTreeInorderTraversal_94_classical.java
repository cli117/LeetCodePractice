package PCRecursion;

import java.util.List;
import java.util.ArrayList;

//      1
//   2     3
//4     5
// Inorder:     4 2 5 1 3
// Preorder:    1 2 4 5 3
// Postorder:   4 5 2 3 1
// Breadth 1st: 1 2 3 4 5
public class _BinaryTreeInorderTraversal_94_classical {
    private class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List <Integer> inorderTraversal(TreeNode root)
    {
        List <Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null)
            {
                helper(root.right, res);
            }
        }
    }
}
