public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int base = 1;
        while (x / 10 >= base) base *= 10;
        while (x != 0) {
            if (x % 10 != x / base) return false;
            x = (x %= base) / 10;
            base /= 100;
        }
        return true;
    }
}