package T436寻找右区间;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [][] arr=new int[][]{{3,4},{2,3},{1,2}};
        int[] rightInterval = new Solution().findRightInterval(arr);
        for (int a :rightInterval) {
            System.out.print(a+" ");
        }
    }
    public int[] findRightInterval(int[][] intervals) {
        //数组元素第一个子元素是左区间的值，第二个子元素是区间下标
        int length = intervals.length;
        int[][] nums=new int[length][2];
        for (int i = 0; i < length; i++) {
            nums[i]=new int[]{intervals[i][0],i};
        }
        quickSort(nums,0, length-1);
        Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[length];
        for (int i=0;i<length;i++){
            int l = 0, r = length - 1;
            while (l < r) {
                int mid =( l + r ) / 2;
                if (nums[mid][0] >= intervals[i][1]) r = mid;
                else l = mid + 1;
            }
            ans[i] = nums[r][0] >= intervals[i][1] ? nums[r][1] : -1;
        }
        return ans;
    }

    public void quickSort(int[][] arr, int l ,int r) {
        if (l>=r) return;
        int i=l;
        int j=r;
        while(i<j){
            while (i<j && arr[j][0]>=arr[l][0]) j--;
            while (i<j && arr[i][0]<=arr[l][0]) i++;
            swap(arr,i,j);
        }
        swap(arr,l,i);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
    public void swap(int[][] arr,int a,int b){
        int temp1 =arr[a][0];
        int temp2=arr[a][1];
        arr[a][0]=arr[b][0];
        arr[a][1]=arr[b][1];
        arr[b][0]=temp1;
        arr[b][1]=temp2;
    }
}
