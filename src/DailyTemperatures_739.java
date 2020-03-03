import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        stack.push(0);
        for (int i = 1; i < T.length; i++)
        {
            if (T[i] < T[stack.peek()])
                stack.push(i);
            else
                {
                    int pos = i;
                    while (!stack.empty() && T[stack.peek()] < T[i])
                    {
                        result[stack.peek()] = i - stack.pop();
                    }
                    stack.push(i);
                }
        }
        return result;
    }
}
