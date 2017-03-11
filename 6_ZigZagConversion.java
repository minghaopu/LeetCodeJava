public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < 2) return s;
        
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) sb[i] = new StringBuilder();
        
        int cycle = 2 * numRows - 2, len = c.length;
        for (int i = 0; i < len; ++i) {
            int offset = i % cycle;
            if (offset < numRows) {
                sb[offset].append(c[i]);
            } else {
                sb[cycle - offset].append(c[i]);
            }
        }
        
        String res = "";
        for (int i = 0; i < numRows; ++i) {
            res += sb[i];
        }
        return res.toString();
    }
}