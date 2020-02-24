import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {
    public int singleNumber(int[] nums)
    {
        Set<Integer> intSet = new HashSet<>();
        for (int num : nums)
        {
            if (!intSet.contains(num))
            {
                intSet.add(num);
            }
            else
            {
                intSet.remove(num);
            }
        }
        return intSet.iterator().next();
    }
}
