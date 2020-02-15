public class FirstMissingPositive_41_HAVENTDONE {
//    public static int firstMissingPositive(int[] nums)
//    {
//        // O(n) but using extra space
//        if (nums.length == 0) return 1;
//        int[] marks = new int[nums.length];
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i] > 0 && nums[i] <= marks.length)
//            {
//                marks[nums[i] - 1] = 1;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (marks[i] == 0)
//            {
//                return i + 1;
//            }
//        }
//        return marks.length + 1;
//    }

    // TODO: FINISH THIS!
    // Idea: 在array里进行操作 连环操作 直到不能操作 然后往下挪一位
    public static int firstMissingPositive(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int pos = i;
            while (pos >= 0 && pos < nums.length && nums[pos] > 0 && nums[pos] < nums.length)
            {
                int temp = nums[nums[pos] - 1];
                nums[nums[pos] - 1] = -1;
                pos = temp;
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0 && nums[i] <= nums.length)
            {
                return i;
            }
        }
        return nums.length;
    }
}
