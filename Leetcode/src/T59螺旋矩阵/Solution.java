package T59螺旋矩阵;

public class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] arr = new int[n][n];
        int k = 1;
        while (k <= n * n) {
            for (int i = l; i <= r; i++) {
                arr[t][i] = k++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                arr[i][r] = k++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                arr[b][i] = k++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                arr[i][l] = k++;
            }
            l++;
        }
        return arr;
    }
}
