import java.util.ArrayList;
import java.util.List;

public class _FindAllNumDisapInArray_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            // Turn to negative only when the element is positive.
            // Or we will mark elements appeared even times as disappeared element
            nums[Math.abs(nums[i]) - 1] *= nums[Math.abs(nums[i]) - 1] > 0 ? -1 : 1;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}
