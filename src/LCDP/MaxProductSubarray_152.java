package LCDP;

public class MaxProductSubarray_152 {
    public int maxProduct(int[] nums)
    {
        if (nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            // imax, imin: 代表到此为止可以提供给后面的最大/最小值
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }
}
