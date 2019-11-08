package code;

public class removeDupFromSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] != prev)
            {
                nums[length++] = nums[i];
                prev = nums[i];
            }
        }
        return length;
    }
}
