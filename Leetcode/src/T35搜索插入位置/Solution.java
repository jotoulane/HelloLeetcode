package T35搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if(nums[len-1]<target){
            return len;
        }
        int left=0,right=len-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
