package LCDP;

public class MinPathSum_64 {
    public int minPathSum(int[][] grid)
    {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int WIDTH = grid[0].length;
        int HEIGHT = grid.length;
        int[][] dp = new int[HEIGHT][WIDTH];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < WIDTH; i++)
        {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < HEIGHT; i++)
        {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < HEIGHT; i++)
        {
            for (int j = 1; j < WIDTH; j++)
            {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[HEIGHT - 1][WIDTH - 1];
    }
}
