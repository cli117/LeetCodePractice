package LCArrays;

public class medianOfTwoSortedArray_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        // Merge two sorted array
        int[] sorted = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        // O(m) or O(n) depending on whose length is smaller
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                sorted[k++] = nums1[i++];
            }
            else
            {
                sorted[k++] = nums2[j++];
            }
        }
        // O(n) or O(m) depending on whose length is larger
        // Different length
        while(i < nums1.length)
        {
            sorted[k++] = nums1[i++];
        }

        while(j < nums2.length)
        {
            sorted[k++] = nums2[j++];
        }


        // Find the median, O(1)
        if(k % 2 == 0)
        {
            return (((double)sorted[k/2 - 1] + (double)sorted[k/2])/2);
        }
        else
        {
            return sorted[k/2];
        }
    }
}

// Time complexity: O(m+n), (m+n) times assignments
// Space complexity: O(m+n), newly constructed array of length (m+n)