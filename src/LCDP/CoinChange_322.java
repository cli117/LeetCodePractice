package LCDP;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount];
//        dpRecursion(coins, amount, dp);
//        return dp[dp.length - 1];
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if (coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int dpRecursion(int[] coins, int amount, int[] dp)
    {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount - 1] != 0) return dp[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
        {
            int res = dpRecursion(coins, amount - coins[i], dp);
            if (res >= 0 && res < min)
            {
                min = 1 + res;
            }
        }
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }
}
