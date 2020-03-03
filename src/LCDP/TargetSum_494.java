package LCDP;

public class TargetSum_494 {
//    // Brute force recursion
//    int count = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        calculate(nums, 0, 0, S);
//        return count;
//    }
//    public void calculate(int[] nums, int i, int sum, int S) {
//        if (i == nums.length) {
//            if (sum == S)
//                count++;
//        } else {
//            calculate(nums, i + 1, sum + nums[i], S);
//            calculate(nums, i + 1, sum - nums[i], S);
//        }
//    }

    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0]+1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++)
        {
            for (int j = -1000; j <= 1000; j++)
            {
                dp[i][j + 1000] = dp[i - 1][j - nums[i] + 1000] + dp[i - 1][j + nums[i] + 1000];
            }
        }
        return dp[nums.length - 1][S - 1 + 1000];
    }
}
