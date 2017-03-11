public class Solution {
    public String longestPalindrome(String s) {
        int[][] table = new int[1000][1000];
        int start = 0, length = 1, l = s.length();
        for (int i = 0; i < l; ++i) table[i][i] = 1;
        for (int i = 0; i < l - 1; ++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = 1;
                start = i;
                length = 2;
            }
        }
        for (int len = 3; len <= l; ++len) {
            for (int i = 0; i < l - len + 1; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && table[i+1][j-1] == 1) {
                    table[i][j] = 1;
                    start = i;
                    length = len;
                }
            }
        }
        return s.substring(start, start + length);
    }
}