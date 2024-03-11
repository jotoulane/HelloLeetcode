package T977有序数组的平方;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int []arr=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i]=nums[i]*nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
