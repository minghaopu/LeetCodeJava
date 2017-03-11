public class Solution {
    public int romanToInt(String s) {
        int pre = Integer.MAX_VALUE, num = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = 0;
            switch (s.charAt(i)) {
                case 'M':
                    val = 1000;
                    break;
                case 'D':
                    val = 500;
                    break;
                case 'C':
                    val = 100;
                    break;
                case 'L':
                    val = 50;
                    break;
                case 'X':
                    val = 10;
                    break;
                case 'V':
                    val = 5;
                    break;
                case 'I':
                    val = 1;
                    break;
            }
            if (pre < val) num = num - pre + val - pre;
            else num += val;
            pre = val;
        }
        return num;
    }
}