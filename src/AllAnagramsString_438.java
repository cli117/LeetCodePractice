import java.util.ArrayList;
import java.util.List;

public class AllAnagramsString_438 {
//    public List<Integer> findAnagrams(String s, String p) {
//        if (s.length() == 0 || p.length() == 0) return null;
//        List<Integer> result = new ArrayList<>();
//        int[] need = new int[26];
//        for (int i = 0; i < p.length(); i++)
//        {
//            need[p.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i + p.length() <= s.length(); i++)
//        {
//            window(s, p, result, i, need);
//        }
//        return result;
//    }
//
//    private void window(String s, String p, List<Integer> result, int start, int[] need)
//    {
//        int[] needCopy = need.clone();
//        for (int i = start; i < start + p.length(); i++)
//        {
//            if (--needCopy[s.charAt(i) - 'a'] < 0) return;
//        }
//        for (int i = 0; i < needCopy.length; i++)
//        {
//            if (needCopy[i] != 0) return;
//        }
//        result.add(start);
//    }

    // 双指针法
public List<Integer> findAnagrams(String s, String p) {
    if(s == null || s.length() == 0) return new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
    int[] window = new int[26];
    int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
    for(char ch : p.toCharArray()){
        needs[ch - 'a'] ++;
    }
    while(right < s.length()){
        char chr = s.charAt(right);
        if(needs[chr - 'a'] > 0){
            window[chr - 'a'] ++;
            if(window[chr - 'a'] <= needs[chr - 'a']){
                total --;
            }
        }
        while(total == 0){
            if(right-left+1 == p.length()){
                res.add(left);
            }
            char chl = s.charAt(left);
            if(needs[chl - 'a'] > 0){
                window[chl - 'a'] --;
                if(window[chl - 'a'] < needs[chl - 'a']){
                    total ++;
                }
            }
            left ++;
        }
        right ++;
    }
    return res;
}
}
