package LCArrays;

import java.util.Stack;

public class LargestRecInHistogram_84 {
//    // Divide and conquer, divide to 2 sub-problem each time
//    public int calculateArea(int[] heights, int start, int end)
//    {
//        if (start > end)
//            return 0;
//        int minindex = start;
//        for (int i = start; i <= end; i++)
//        {
//            if (heights[minindex] > heights[i])
//            {
//                minindex = i;
//            }
//        }
//        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
//    }
//    public int largestRectangleArea(int[] heights)
//    {
//        return calculateArea(heights, 0, heights.length - 1);
//    }


    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack = new Stack <> ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i)
        {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
            {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1)
        {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxarea;
    }
}
