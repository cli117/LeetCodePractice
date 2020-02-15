package LCDP;

public class _UniqueBST_96 {

    // G[i] = ∑ G(i−1)⋅G(n−i)
    // https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
    public int numTrees(int n)
    {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i)
        {
            for (int j = 1; j <= i; ++j)
            {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
