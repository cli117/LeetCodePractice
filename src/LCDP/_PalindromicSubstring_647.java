package LCDP;

public class _PalindromicSubstring_647 {
    int count = 0;
    public int countSubstrings(String s) {
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        for (int j = 0; j < s.length(); j++)
//        {
//            for (int i = j; i >= 0; i--)
//            {
//                // i 需要 i + 1 提前算好，所以i应当倒着来
//                // j 需要 j - 1 提前算好，所以j正着算
//                if (s.charAt(i) == s.charAt(j) && ( j - i < 2 || dp[i + 1][j - 1]))
//                {
//                    dp[i][j] = true;
//                    count++;
//                }
//            }
//        }
//        return count;

        // 两种可能往外延伸，单独一个为起点和相邻的两个相同char为起点
        for (int i = 0; i < s.length(); i++)
        {
            recursion(s, i, i);
            if (i + 1 < s.length())
            {
                recursion(s, i, i + 1);
            }
        }
        return count;
    }

    private void recursion(String s, int start, int end)
    {
        // 超出边界 结束
        if (start < 0 || end > s.length() - 1) return;
        // 如果新加入的两个char相等 count++并且查看下一个
        // 如果不等 以recursion最初的起点为起点的字符串不再有新的回文字符串
        if (s.charAt(start) == s.charAt(end))
        {
            count++;
            recursion(s, start - 1, end + 1);
        }
    }
}
