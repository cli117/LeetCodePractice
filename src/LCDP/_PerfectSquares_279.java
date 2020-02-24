package LCDP;

import java.util.ArrayDeque;
import java.util.Queue;

public class _PerfectSquares_279 {
//    public static int numSquares(int n) {
//        int[] dp = new int[n+1];
//        for (int i = 1; i < dp.length; i++)
//        {
//            // Here we must assign dp[i] = i outside of the inner loop
//            // Since the smallest dp[i] could appear at the first inner iteration, if we use i instead of dp[i]
//            // Things could be wrong
//            dp[i] = i;
//            for (int j = 1; i - j * j >= 0; j++)
//            {
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//            }
//        }
//        return dp[n];
//    }

    public static int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        int depth = 0;
        while (!queue.isEmpty())
        {
            depth++;
            int ite = queue.size();
            for (int j = 0; j < ite; j++)
            {
                int curr = queue.poll();
                for (int i = 1; curr - i * i >= 0; i++)
                {
                    if (curr - i * i == 0)
                    {
                        return depth;
                    }
                    queue.offer(curr - i * i);
                }
            }

        }
        return depth;
    }
}
