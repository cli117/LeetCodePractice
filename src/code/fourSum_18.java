package code;
import java.util.*;

public class fourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int l0 = 0, l1 = 1, l2 = 2, r0 = nums.length - 1;
        int currentSum, diff;
        HashMap<Integer, Integer> haspMap = new HashMap<>();
        while (l0 < r0 - 2)
        {
            while (l1 < r0 - 1)
            {
                currentSum = nums[l0] + nums[l1] + nums[l2] + nums[r0];
                diff = Math.abs(currentSum - target);
                if (diff == 0)
                {
                    List<Integer> toAdd = Arrays.asList(new Integer[] {nums[l0], nums[l1], nums[l2], nums[r0]});
                    if (haspMap.get(hashCode(toAdd)) == null)
                    {
                        result.add(toAdd);
                        haspMap.put(hashCode(toAdd), 1);
                    }
                    l2++;
                    r0 = nums.length - 1;
                }
                else if (currentSum > target)
                {
                    r0--;
                }
                else
                {
                    l2++;
                }
                if (l2 == r0)
                {
                    l1++;
                    l2 = l1 + 1;
                    r0 = nums.length - 1;
                }
            }
            if (l1 + 1 == r0)
            {
                l0++;
                l1 = l0 + 1;
                l2 = l1 + 1;
                r0 = nums.length - 1;
            }
        }
        return result;
    }

    public static int hashCode(List<Integer> list)
    {
        return Arrays.hashCode(list.toArray());
    }
}
