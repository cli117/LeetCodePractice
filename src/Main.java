import PCRecursion.PathSum_437;

// _ 在代码前面代表没想出来最优解
public class Main {
    public static void main(String[] args) {
        PathSum_437.TreeNode root = new PathSum_437.TreeNode(1);
        root.left = new PathSum_437.TreeNode(-2);
        root.right = new PathSum_437.TreeNode(-3);
        root.left.left = new PathSum_437.TreeNode(1);
        root.left.right = new PathSum_437.TreeNode(3);
        root.right.left = new PathSum_437.TreeNode(-2);
        root.left.left.left = new PathSum_437.TreeNode(-1);
        PathSum_437 test = new PathSum_437();
        test.pathSum(root, 3);
    }
}


