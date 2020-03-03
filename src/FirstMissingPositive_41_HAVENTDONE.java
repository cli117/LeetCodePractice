public class FirstMissingPositive_41_HAVENTDONE {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
        {
            // Last statement for situation like [1, 1]
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i && nums[nums[i] - 1] != nums[i])
            {
                swap(nums, i, nums[i--] - 1);
            }
        }

        int i = 0;
        for (; i < nums.length; i++)
        {
            if (nums[i] - 1 != i)
                break;
        }
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
