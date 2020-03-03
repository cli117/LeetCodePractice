package LCBackTrack;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            hashSet.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (hashSet.containsKey(target - nums[i]) && hashSet.get(target - nums[i]) != i)
            {
                res[0] = i;
                res[1] = hashSet.get(target - nums[i]);
            }
        }
        return res;
    }
}
