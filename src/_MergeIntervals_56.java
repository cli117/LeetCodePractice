import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class _MergeIntervals_56 {

    public static class Interval implements Comparable<Interval>
    {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public int compareTo(Interval b)
        {
            return this.start < b.start ? -1 : this.start == b.start ? 0 : 1;
        }

        @Override
        public String toString()
        {
            return "(" + start + ", " + end + ")";
        }

        public int[] toIntArray()
        {
            return new int[]{ start, end };
        }
    }


    public static int[][] merge(int[][] intervals)
    {
        List<Interval> intervalsAL = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++)
        {
            intervalsAL.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        LinkedList<Interval> merged = new LinkedList<>();
        Collections.sort(intervalsAL);
        for (Interval interval : intervalsAL)
        {
            if (merged.isEmpty() || merged.getLast().end < interval.start)
            {
                merged.add(interval);
            }
            else
            {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int[][] results = new int[merged.size()][];
        for (int i = 0; i < results.length; i++)
        {
            results[i] = merged.get(i).toIntArray();
        }
        return results;
    }
}
