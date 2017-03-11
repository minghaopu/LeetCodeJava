public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (cache.containsKey(rest)) {
                res[0] = cache.get(rest);
                res[1] = i;
            }
            cache.put(nums[i], i);
        }
        return res;
    }
}