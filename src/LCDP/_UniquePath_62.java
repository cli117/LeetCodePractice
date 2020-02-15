package LCDP;

import java.util.Arrays;

public class _UniquePath_62 {
    public static int uniquePaths(int m, int n)
    {
//        // Traditional 2d array to do DP
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++)
//        {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 0; i < n; i++)
//        {
//            dp[0][i] = 1;
//        }
//
//        for (int i = 1; i < m; i++)
//        {
//            for (int j = 1; j < n; j++)
//            {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];

        // Use 1d array instead
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 1; j < dp.length; j++)
            {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m-1];
    }
}
