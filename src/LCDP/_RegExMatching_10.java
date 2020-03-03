package LCDP;

public class _RegExMatching_10 {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        // Check if the first char is a match
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // Check if the following char is a Kleene stars *.
        if (p.length() >= 2 && p.charAt(1) == '*')
        {
            // if so, either check the pattern after * can be found in the String or
            // the first char is a match and the remaining s can match the pattern p as well
            // we need the second statement to get case like 'aa' 'a*' right
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        }
        else
        {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
    }

enum Result {
    TRUE, FALSE
}

class _10Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    // Time complexity: O(TP) for filling the array
    // Space complexity: O(TP) for the array
}