package T7整数反转;

public class Solution {
    public static void main(String[] args) {
        int x = -900000;
        System.out.println(new Solution().reverse(x));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            if (result > 214748364 || (result > 214748364 && temp > 7)) {
                return 0;
            }
            if (result < -214748364 || (result < -214748364 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
            x /= 10;
        }

        return result;
    }
}
