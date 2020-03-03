import java.util.HashMap;

public class _SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            // Must check if exist first. Or things could go wrong when k = 0.
            // Example: nums = [1], k = 0
            if (hashMap.containsKey(sum - k))
            {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
