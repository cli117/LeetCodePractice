import java.util.Stack;

public class _LongestValidParentheses_32 {
    public int longestValidParentheses(String s)
    {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(-1);
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                myStack.push(i);
            }

            else
            {
                if (myStack.isEmpty())
                {
                    myStack.push(i);
                }
                else
                {
                    myStack.pop();
                    if (myStack.isEmpty())
                    {
                        myStack.push(i);
                    }
                    else
                    {
                        currentLength = Math.max(currentLength, i - myStack.peek());
                    }
                }
            }
        }
        return currentLength;
    }
}
