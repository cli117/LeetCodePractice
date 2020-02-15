package PCRecursion;

public class _NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        // Algo:
        // Find the first pair of integers that has descending order from right to left. say nums[i] and nums[i+1]
        // (i.e. nums[i] < nums[i+1] and for all j > i, nums[j] > nums[j+1])
        // And find the first integer bigger than the nums[i] from right to left. say nums[k]
        // Swap nums[i] and nums[k]
        // Then sort the numbers after nums[i] in ascending order(from left to right)
        // Here we find the smallest digit that can be bigger, and we let the number become larger as little as possible.

        int swapA = -1, swapB = -1;
        boolean isLargest = true;
        for (int i = nums.length - 1; i > 0; i--)
        {
            if (nums[i] > nums[i-1])
            {
                // if descending order
                swapA = i-1;
                isLargest = false;
                break;
            }
        }

        if (!isLargest)
        {
            for (int i = nums.length - 1; i > 0; i--)
            {
                if (nums[i] > nums[swapA])
                {
                    swapB = i;
                    break;
                }
            }
            int temp = nums[swapA];
            nums[swapA] = nums[swapB];
            nums[swapB] = temp;

            sort(nums, swapA+1, nums.length - 1);
        }
        else
        {
            int i, t;
            for (i = 0; i < nums.length / 2; i++) {
                t = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = t;
            }
        }
    }

    // Following code are quicksort from geekforgeek.com
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
