public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length; i++)
//        {
//            int j;
//            if (nums[i] == 0)
//            {
//                j = i + 1;
//                while (nums[j] == 0)
//                {
//                    j++;
//                    if (j == nums.length) return;
//                }
//                int temp = nums[j];
//                nums[j] = 0;
//                nums[i] = temp;
//            }
//        }

        // Dont have to do the swap
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
