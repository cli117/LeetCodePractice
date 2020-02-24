import java.util.ArrayList;
import java.util.PriorityQueue;

public class _FindMedianFromDataStream_295 {
    static class MedianFinder
    {
        PriorityQueue<Integer>  minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
            {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == 0 && minHeap.size() == 0) return 0;
            return maxHeap.size() > minHeap.size() ? (double)maxHeap.peek() : (double)(maxHeap.peek() + minHeap.peek())/2;
        }
    }
}
