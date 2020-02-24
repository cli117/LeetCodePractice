import java.util.HashSet;
import java.util.Set;

public class _LongestConsecutiveSeq_128 {
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
        {
            numSet.add(num);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (!numSet.contains(nums[i] - 1))
            {
                int current = nums[i];
                int currentStreak = 1;

                while (numSet.contains(++current))
                {
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
