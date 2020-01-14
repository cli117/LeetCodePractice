package LCArrays;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    // Time complexity: O(n^2), n iterations of n iterations
    // Space complexity: O(1), no new array is built.
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j, k, sum, bestSum, targetWidth, prevTargetWidth;
        sum = bestSum = targetWidth = prevTargetWidth = Integer.MAX_VALUE;

        for (i = 0, j = 1, k = nums.length-1; i+1 < k;) {

            sum = nums[i] + nums[j] + nums[k];
            targetWidth = Math.abs(sum - target);

            if (targetWidth == 0){
                return sum;
            } else if (sum > target) {  // far away from target, decrement end pointer
                k--;
            } else {  // getting closer, increment middle pointer
                j++;
            }
            if (j == k) {  // middle meets end pointers, reset all
                i++;
                j = i+1;
                k = nums.length-1;
            }
            if (targetWidth < prevTargetWidth){
                prevTargetWidth = targetWidth;
                bestSum = sum;
            }
        }
        return bestSum;
    }


    public static int mySlowerThreeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestDiff = Integer.MAX_VALUE, bestSum = 0, currentSum;
        for (int i = 0; i < nums.length - 2; i++)
        {
            // Construct the complementary array
            // Time: O(n)
            // Space: O(n)
            int[] complementaryArray = new int[nums.length - 1];
            int pos = 0;
            for (int j = 0; j < complementaryArray.length; j++)
            {
                if (pos == i) pos++;
                complementaryArray[j] = nums[pos++];
            }
            currentSum = nums[i] + mySlowerTwoSumClosest(complementaryArray, target - nums[i]);
            if (Math.abs(target - currentSum) < bestDiff)
            {
                bestSum = currentSum;
                bestDiff = Math.abs(target - bestSum);
            }
        }
        return bestSum;
    }

    public static int mySlowerTwoSumClosest(int[] nums, int target)
    {
        int head = 0, tail = nums.length - 1;
        int bestHead = head, bestTail = tail, diff, bestDiff = Integer.MAX_VALUE;
        while (head < tail)
        {
            diff = nums[head] + nums[tail] - target;
            if (Math.abs(diff) < bestDiff) bestDiff = Math.abs(diff);
            if (bestDiff == 0) return target;
            if (diff < 0)
            {
                head++;
                // skip same numbers
                while (head < tail && nums[head] == nums[head - 1])
                {
                    head++;
                }
                if (head == tail) break;
                if (Math.abs(nums[head] + nums[tail] - target) < bestDiff)
                {
                    bestHead = head;
                    bestTail = tail;
                }
            }
            else
            {
                tail--;
                while (head < tail && nums[tail] == nums[tail + 1])
                {
                    tail--;
                }
                if (head == tail) break;
                if (Math.abs(nums[head] + nums[tail] - target) < bestDiff)
                {
                    bestHead = head;
                    bestTail = tail;
                }
            }
        }
        return nums[bestHead] + nums[bestTail];
    }
}
