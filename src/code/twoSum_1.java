package code;
import java.util.HashMap;

public class twoSum_1 {
    public static int[] twoSum(int[] nums, int target)
    {
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    toReturn[0] = i;
                    toReturn[1] = j;
                }
            }
        }
        return toReturn;
    }
    // Time complexity: O(n^2) , nested loop
    // Space complexity: O(1), no new variable


    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
            {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    // Hashtable, synchronized, multi-thread safe.
    // Hashmap, not synchronized.
    // Time complexity: O(n), each iteration is O(1) and n iterations.
    // Space complexity: O(n), size n hashmap

}
