package T75颜色分类;

public class Solution {
    public static void main(String[] args) {
        int [] arr=new int[]{2,0,2,1,1,0};
        new Solution().sortColors(arr);
        for (int a :arr) {
            System.out.print(a+" ");
        }
    }
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums,int left ,int right){
        if(left>=right){
            return ;
        }
        int i=left,j=right;
        while(i<j){
            while(i<j && nums[j]>=nums[left]) j--;
            while(i<j && nums[i]<=nums[left]) i++;
            swap(nums,i,j);
        }
        swap(nums,left,i);
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public void swap(int[]nums,int a,int b ){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
