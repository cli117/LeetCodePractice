public class _BuyNSellStock_121 {
    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > max_profit) max_profit = prices[i] - min;
        }
        return max_profit;
    }
}
