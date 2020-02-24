package LCDP;

public class _BestTimeStockWithCD_309 {
    public int maxProfit(int[] prices) {
        // 不需要二维计算时，不需要建立array 只需要根据旧值算新值，节约空间
        // 需要i-2时，也可多用一个变量，每次循环结束将i-1赋值给变量。对于下一个iteration 它的值就是i-2
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
