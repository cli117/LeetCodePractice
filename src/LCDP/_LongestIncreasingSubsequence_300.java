package LCDP;

public class _LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++)
        {
            int max = 0;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
