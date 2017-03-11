public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        char[] c = str.toCharArray();
        
        int len = c.length, start = 0, end = len - 1, sign = 1, total = 0;
        while (start < len && c[start] == ' ') start++;
        while (end > 0 && c[end] == ' ') end--;
        
        if (start <= end && c[start] == '+' || c[start] == '-') {
            if (c[start] == '-') sign = -1;
            start++;
        }
        
        while (start <= end) {
            if (Character.isDigit(c[start])) {
                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < c[start] - '0') {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                
                total = 10 * total + c[start] - '0';
            } else break;
            start++;
        }
        return total * sign;
    }
}