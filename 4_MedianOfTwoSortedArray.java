public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        if (n == 0) return (double) (nums1[(m-1)/2] + nums1[m/2]) / 2;
        int low = 0, high = 2 * n;
        while(low <= high) {
            int mid2 = (low + high) / 2;
            int mid1 = m + n - mid2;
            
            double l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1-1)/2];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double r1 = mid1 == 2 * m ? Integer.MAX_VALUE : nums1[mid1/2];
            double r2 = mid2 == 2 * n ? Integer.MAX_VALUE : nums2[mid2/2];
            
            if (l1 > r2) low = mid2 + 1;
            else if (l2 > r1) high = mid2 - 1;
            else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
        return -1;
    }
}