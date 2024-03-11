package 捕获;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class func {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 敌人数量
        int a = sc.nextInt(); // 横坐标最大差值
        int b = sc.nextInt(); // 纵坐标最大差值
        int ans = 0; // 最多能捕获的敌人数量
        int[][] arr = new int[n][2]; // 敌人坐标数组
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // 敌人横坐标
            arr[i][1] = sc.nextInt(); // 敌人纵坐标
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // 按横坐标排序
        int left = 0, right = 0; // 滑动窗口的左右边界
        while (right < n) {
            while (arr[right][0] - arr[left][0] > a) {
                left++; // 缩小窗口左边界
            }
            int minY = arr[left][1], maxY = arr[left][1]; // 窗口中的纵坐标范围
            for (int i = left + 1; i <= right; i++) {
                minY = Math.min(minY, arr[i][1]);
                maxY = Math.max(maxY, arr[i][1]);
            }
            if (maxY - minY <= b) {
                ans = Math.max(ans, right - left + 1); // 更新最多能捕获的敌人数量
            }
            right++; // 扩大窗口右边界
        }
        System.out.println(ans); // 输出结果
        sc.close();
    }
}
