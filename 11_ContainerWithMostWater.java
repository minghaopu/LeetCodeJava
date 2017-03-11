public class Solution {
    public int maxArea(int[] height) {
        int water = 0;
        int l = 0, r = height.length - 1;
        int h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            water = Math.max(h * (r - l), water);
            while (l < r && height[l] <= h) l++;
            while (l < r && height[r] <= h) r--;
        }
        return water;
    }
}