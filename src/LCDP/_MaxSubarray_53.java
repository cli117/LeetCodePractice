package LCDP;

public class _MaxSubarray_53 {

    public int maxSubArray(int[] nums)
    {
//        // DP: Not using 2d array since we can calculate the newer result based on current value and update it.
//        // Not very efficient tho :(
//        // O(n^2)
//        int[] dp = new int[nums.length];
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++)
//        {
//            for (int j = 0; j < nums.length - i; j++)
//            {
//                dp[i] += nums[i+j];
//                max = dp[i] > max ? dp[i] : max;
//            }
//        }
//        return max;


        // More efficient DP, calculate the max length until k th number
        // Based on k-1 th positivity
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++)
        {
            //update dp[i] based on the positivity of dp[i-1]
            if (dp[i - 1] < 0)
            {
                dp[i] = nums[i];
            }
            else
            {
                dp[i] = dp[i - 1] + nums[i];
            }
            //update max
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
