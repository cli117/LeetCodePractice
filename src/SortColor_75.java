public class SortColor_75 {
    public static void sortColors(int[] nums)
    {
//        // Two pass
//        int zeros = 0, ones = 0, twos = 0;
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i] == 0)
//            {
//                zeros++;
//            }
//            if (nums[i] == 1)
//            {
//                ones++;
//            }
//            if (nums[i] == 2)
//            {
//                twos++;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (--zeros >= 0)
//            {
//                nums[i] = 0;
//                continue;
//            }
//            if (--ones >= 0)
//            {
//                nums[i] = 1;
//                continue;
//            }
//            if (--twos >= 0)
//            {
//                nums[i] = 2;
//            }
//        }

        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
