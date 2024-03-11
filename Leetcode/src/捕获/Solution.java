package 捕获;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner re=new Scanner(System.in);
        int n=re.nextInt();
        int a=re.nextInt();
        int b=re.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=re.nextInt();
            arr[i][1]=re.nextInt();
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // 初始值为1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i][0] - arr[j][0]) <= a && Math.abs(arr[i][1] - arr[j][1]) <= b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
