package LCDP;

public class _LongestPalindromicString_5
{
    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return s;
        String longest = "";
        int[][] paliDP = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                if (isPalindromic(i, j, paliDP, s) == 1 && j - i + 1 > longest.length())
                {
                    longest = s.substring(i, j+1);
                }
            }
        }
        return longest;
    }

    public static int isPalindromic(int left, int right, int[][] paliDP, String s)
    {
        if (paliDP[left][right] != 0) return paliDP[left][right];
        else if (left == right || (right == left + 1 && s.charAt(left) == s.charAt(right)))
        {
            paliDP[left][right] = 1;
            return 1;
        }
        else if (s.charAt(left) == s.charAt(right) && isPalindromic(left+1, right-1, paliDP, s) == 1)
        {
            paliDP[left][right] = 1;
            return 1;
        }
        paliDP[left][right] = 0;
        return 0;
    }
}

// Another way to solve w/ better running time & memory usage
class _5Solution {
    public String longestPalindrome(String s) {
        Pair longest = new Pair(0, 0);
        for (int i = 0; i < s.length(); i++) {
            Pair s1 = this.getPalindrome(s, i, i);
            Pair s2 = this.getPalindrome(s, i, i+1);
            longest = this.max(longest, s1, s2);
        }
        return this.obtainSubstr(s, longest);
    }

    public Pair getPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start -= 1;
            end += 1;
        }
        return new Pair(start + 1, end);
    }

    public Pair max(Pair s1, Pair s2, Pair s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 >= l2 && l1 >= l3) {
            return s1;
        } else if (l2 >= l3) {
            return s2;
        }
        return s3;
    }

    public String obtainSubstr(String s, Pair longest) {
        return s.substring(longest.p1, longest.p2);
    }
}

class Pair {
    public int p1;
    public int p2;

    public Pair(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static Pair with(int p1, int p2) {
        return new Pair(p1, p2);
    }

    public int length() {
        return this.p2 - this.p1;
    }
}
