package LCBackTrack;

public class JumpGame_55 {
//    // Backtrack would work, but O(2^n)
//    public static boolean canJump(int[] nums)
//    {
//        return backtrack(0, nums);
//    }
//    private static boolean backtrack(int initPos, int[] nums)
//    {
//        if (initPos == nums.length - 1)
//        {
//            return true;
//        }
//
//        for (int i = 0; i < nums[initPos]; i++)
//        {
//            if (backtrack(initPos + i + 1, nums))
//            {
//                return true;
//            }
//        }
//        return false;
//    }

    // Mark the last reachable pos
    // If the lastPos == 0, then it can jump to the last pos
    public static boolean canJump(int[] nums)
    {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (i + nums[i] >= lastPos)
            {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
