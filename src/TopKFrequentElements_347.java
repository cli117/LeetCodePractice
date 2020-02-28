import java.util.*;

public class TopKFrequentElements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k == 0) return new ArrayList<Integer>();
        if (nums.length == 0) return null;
        HashMap<Integer, Integer> numFrequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (!numFrequency.containsKey(nums[i]))
            {
                numFrequency.put(nums[i], 1);
            }
            else
            {
                numFrequency.put(nums[i], numFrequency.get(nums[i]) + 1);
            }
        }

        PriorityQueue<HashMap.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                if (o1.getValue() > o2.getValue()) return -1;
                return 0;
            }
        });

        for (HashMap.Entry<Integer, Integer> entry : numFrequency.entrySet())
        {
            maxHeap.offer(entry);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < k; i++)
        {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}
