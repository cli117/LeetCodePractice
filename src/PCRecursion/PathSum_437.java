package PCRecursion;

public class PathSum_437 {

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int path = 0, prevSum;

    public int pathSum(TreeNode root, int sum) {
        return 0;
    }

    public int recursion(TreeNode root, int sum, int[] path, int pos)
    {
        if (root == null) return 0;
        // n represents the # path so far
        int n = 0, tempSum = 0;
        path[pos] = root.val;
        for (int i = pos; i >= 0; i--)
        {
            tempSum += path[pos];
            if (tempSum == sum) n++;
        }
        return n + recursion(root.left, sum, path, pos+1) + recursion(root.right, sum, path, pos+1);
    }
}
