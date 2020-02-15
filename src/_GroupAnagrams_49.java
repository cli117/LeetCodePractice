import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class _GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs)
    {
//        // Using hashmap, hash String
//        // Each string has a hashable String key
//        // aabc: #2#1#1#0#0#0...
//        List<List<String>> result = new ArrayList<>();
//        Map<String, List<String>> hash = new HashMap<>();
//
//        for (int i = 0; i < strs.length; i++)
//        {
//            int[] nums = new int[26];
//            for (int j = 0; j < strs[i].length(); j++)
//            {
//                nums[strs[i].charAt(j) - 'a']++;
//            }
//            String key = "";
//            for (int j = 0; j < 26; j++)
//            {
//                key += "#" + nums[j];
//            }
//            if (hash.containsKey(key))
//            {
//                hash.get(key).add(strs[i]);
//            }
//            else
//            {
//                hash.put(key, new ArrayList<>());
//                hash.get(key).add(strs[i]);
//            }
//        }
//        for (Map.Entry<String, List<String>> entry : hash.entrySet())
//        {
//            result.add(entry.getValue());
//        }
//        return result;



        // Better performance
        // 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，
        // 要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97, 101, 103 };
        HashMap<Integer, List<String>> hash = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs)
        {
            int key = 1;
            for (int i = 0; i < str.length(); i++)
            {
                key *= primes[str.charAt(i) - 'a'];
            }
            if (hash.containsKey(key))
            {
                hash.get(key).add(str);
            }
            else
            {
                hash.put(key, new ArrayList<>());
                hash.get(key).add(str);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : hash.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
