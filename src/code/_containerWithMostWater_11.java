package code;

public class _containerWithMostWater_11 {
    public static int maxArea(int[] height)
    {
        int maxArea = 0, head = 0, tail = height.length - 1;
        while (head != tail)
        {
            int currentArea;
            // By contradiction:
            // If we move the pointer whose height is larger, then we have no chance that the area will become lager
            // Since height wont increase, and length will decrease by 1
            if (height[head] < height[tail])
            {
                currentArea = (tail - head) * height[head];
                if (maxArea < currentArea) maxArea = currentArea;
                head++;
            }
            else
            {
                currentArea = (tail - head) * height[tail];
                if (maxArea < currentArea) maxArea = currentArea;
                tail--;
            }
        }
        return maxArea;
    }
}

// Time complexity: O(n), n iterations of O(1)
// Space complexity: O(1)