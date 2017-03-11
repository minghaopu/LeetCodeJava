public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] cs = s.toCharArray(), cp = p.toCharArray();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cp[j-1] == '*') {
                    dp[i][j] = dp[i][j-2] || (i > 0 && dp[i-1][j] && (cs[i-1] == cp[j-2] || cp[j-2] == '.'));
                } else {
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (cs[i-1] == cp[j-1] || cp[j-1] == '.');
                }
            }
        }
        return dp[m][n];
    }
}