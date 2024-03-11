package lanqiaobei.T1;


public class Solution {
    public static void main(String[] args) {
        long mod = 1000000000; // 1e9
        long sum = 0;

        for (int i = 1; i <= 39L; i++) {
            long factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial = (factorial * j) % mod; // 计算 i! 的模
            }
            sum = (sum + factorial) % mod; // 加上 i! 的模并对 mod 取模
        }

        System.out.println("digits: " + sum);
    }
}
//485501977
