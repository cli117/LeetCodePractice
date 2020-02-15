package LCBackTrack;

import java.util.List;
import java.util.ArrayList;

public class Permutations_46 {
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), results);
        return results;
    }

    private static void backtrack(int[] nums, List<Integer> element, List<List<Integer>> results)
    {
        if (element.size() == nums.length)
        {
            results.add(new ArrayList<>(element));
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!element.contains(nums[i]))
            {
                element.add(nums[i]);
                backtrack(nums, element, results);
                element.remove(element.size() - 1);
            }
        }
    }
}
