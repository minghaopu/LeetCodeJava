public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int cache[] = new int[128];
        int start = 0, length = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            ++cache[c];
            while (cache[c] > 1) {
                --cache[s.charAt(start++)];
            }
            length = Math.max(length, i - start + 1);
        }
        return length;
    }
}