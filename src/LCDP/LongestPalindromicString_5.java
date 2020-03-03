package LCDP;

public class LongestPalindromicString_5 {
    String res = "";
    public String longestPalindrome(String s) {
        // DP
//        boolean[][] dp = new boolean[s.length()][s.length()];
//
//        for (int i = s.length() - 1; i >= 0; i--)
//        {
//            for (int j = i; j < s.length(); j++)
//            {
//                if (s.charAt(i) == s.charAt(j) && ( j - i < 2 || dp[i + 1][j - 1]))
//                {
//                    dp[i][j] = true;
//                    res = j - i + 1 > res.length() ? s.substring(i, j) : res;
//                }
//            }
//        }
//
//        return res;


        for (int i = 0; i < s.length(); i++)
        {
            check(s, i, i);
            if (i + 1 < s.length())
            {
                check(s, i, i + 1);
            }
        }
        return res;
    }

    private void check(String s, int i, int j)
    {
        if (s.charAt(i) == s.charAt(j))
        {
            if (j - i + 1 > res.length())
                res = s.substring(i, j + 1);
            if (i - 1 >= 0 && j + 1 < s.length())
                check(s, i - 1, j + 1);
        }
    }
}
