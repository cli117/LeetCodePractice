public class _FindDupNum_287 {
    public int findDuplicate(int[] nums) {
        // 以node的value代表这个node，nums[value]即为往下走一个
        // 所以slow == fast的时候说明指到了同一个node
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
