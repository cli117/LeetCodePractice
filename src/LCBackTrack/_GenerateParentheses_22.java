package LCBackTrack;
import java.util.ArrayList;
import java.util.List;

public class _GenerateParentheses_22 {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, n, "", 0, 0);
        return result;
    }

    private static void backtrack(ArrayList<String> result, int n, String current, int open, int close) {
        if (current.length() == n * 2 && close == open) {
            result.add(current);
            System.out.println(current);
            return;
        }

        // Note here, open < n, #open parentheses should < a half of the String length
        if (open < n) {
            backtrack(result, n, current + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(result, n, current + ")", open, close + 1);
        }
    }
}
