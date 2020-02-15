package LCBackTrack;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findSum(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void findSum(int[] candidates, int target, List<Integer> element, List<List<Integer>> result, int start)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(element));
        }
        else
        {
            for (int i = start; i < candidates.length; i++)
            {
                if (candidates[i] <= target)
                {
                    element.add(candidates[i]);
                    findSum(candidates, target - candidates[i], element, result, i);
                    element.remove(element.size() - 1);
                }
            }
        }
    }
}
