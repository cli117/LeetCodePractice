public class _ShortestUnsorted_581 {
    // 从前往后 遇见降序
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }
}
