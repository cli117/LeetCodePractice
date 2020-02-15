package LCDP;

public class _EditDistance_72_IMPORTANT {
    // COMP360 A5 Q4
    // Let dp[i][j] represents the distance between a1...ai and b1...bj
    public int minDistance(String word1, String word2) {
        int w1l = word1.length(), w2l = word2.length();
        if (w1l * w2l == 0)
        {
            return w1l + w2l;
        }
        int[][] dp = new int[w1l + 1][w2l + 1];
        for (int i = 1; i <= w1l; i++)
        {
            dp[i][0] = i;
        }

        for (int i = 1; i <= w2l; i++)
        {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] - 1);
                }
                else
                {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
