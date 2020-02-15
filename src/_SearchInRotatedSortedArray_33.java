public class _SearchInRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = -1, result = -1;
        if (right == left)
        {
            if (nums[0] == target) return 0;
            return -1;
        }
        while (left != right)
        {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[left] == target) return left;
            else if (nums[right] == target) return right;
            if (nums[right] < nums[mid] && nums[mid] > target && nums[right] > target)
            {
                if (left == mid) mid++;
                left = mid;
            }
            else if (nums[right] > nums[mid] && nums[mid] > target && nums[right] > target)
            {
                if (right == mid) mid--;
                right = mid;
            }
            else if (nums[right] < nums[mid] && nums[mid] > target && nums[right] < target)
            {
                if (right == mid) mid--;
                right = mid;
            }
            else if (nums[right] > nums[mid] && nums[mid] < target && nums[right] > target)
            {
                if (left == mid) mid++;
                left = mid;
            }
            else if (nums[right] < nums[mid] && nums[mid] < target && nums[right] < target)
            {
                if (left == mid) mid++;
                left = mid;
            }
            else if (nums[right] > nums[mid] && nums[mid] < target && nums[right] < target)
            {
                if (right == mid) mid++;
                right = mid;
            }
            else
            {
                break;
            }
        }
        return result;
    }
}
