import java.util.Stack;

public class _ValidParentheses_20
{
    public static boolean isValid(String s)
    {
        Stack<String> myStack = new Stack<>();
        CheckValidity(s, myStack);
        return myStack.isEmpty();
    }

    public static void CheckValidity(String s, Stack<String> stack)
    {
        if (s.length() == 0) return;
        String current = s.substring(0, 1);
        try
        {
            if (stack.size() == 0) stack.push(current);
            else if (isPaired(stack.peek(), current)) stack.pop();
            else stack.push(current);
        }
        catch (Exception e)
        {

        }
        CheckValidity(s.substring(1), stack);
    }

    public static boolean isPaired(String a, String b)
    {
        if (a.equals("(")) return b.equals(")");
        else if (a.equals("[")) return b.equals("]");
        else return b.equals("}");
    }
}

// The subset of a valid answer is a valid answer too
// We find parentheses inside out, eliminate one pair once we find
// Check if the remaining stack is empty
// Time complexity: O(n)
// Space complexity: O(n)