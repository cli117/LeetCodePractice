package LCDP;

// Idea: The capacity of a specific pos =
// min(highest bar of its left bars, highest bar of its right bars) - height[pos]
// Use DP to store the left highests and right highests, compare it to the next bar to obtain next highest
public class _TrapRainWater_42 {
    public int trap(int[] height)
    {
        if (height.length == 0) return 0;
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        int result = 0;

        leftHighest[0] = height[0];
        rightHighest[rightHighest.length - 1] = height[rightHighest.length - 1];
        for (int i = 1; i < height.length; i++)
        {
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i]);
            rightHighest[height.length - 1 - i] = Math.max(rightHighest[height.length - i], height[height.length - i - 1]);
        }

        for (int i = 1; i < height.length - 1; i++)
        {
            result += Math.min(leftHighest[i], rightHighest[i]) - height[i];
        }
        return result;
    }
}
