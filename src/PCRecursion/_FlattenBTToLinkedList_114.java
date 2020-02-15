package PCRecursion;

public class _FlattenBTToLinkedList_114 {
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root)
    {
        if (root == null) return;
        flattener(root);
        TreeNode tempNode =root;
        while(tempNode.left!=null){
            tempNode.right = tempNode.left;
            tempNode.left = null;
            tempNode= tempNode.right;
        }
    }

    private TreeNode flattener(TreeNode root)
    {
        if (root.left == null && root.right == null) return root;
        if (root.left != null && root.right == null) return flattener(root.left);
        if (root.left == null)
        {
            root.left = root.right;
            root.right = null;
            return flattener(root.left);
        }
        TreeNode temp = flattener(root.left);
        temp.left = root.right;
        root.right = null;
        return flattener(root.left);
    }
}
