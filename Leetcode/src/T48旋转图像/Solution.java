package T48旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        int [][] matrixNew=new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrixNew[j][n-i-1]=matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrixNew[i][j];
            }
        }
    }
}
