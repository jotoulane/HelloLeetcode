package T34在排序数组查找第一和最后一个位置;

public class Solution {
    public static void main(String[] args) {
        int []nums=new int[]{5,7,7,8,8,10};
        int target=8;
        int[] ints = new Solution().searchRange(nums, target);
        for (int a :ints) {
            System.out.print(a+" ");
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int leftIndex=search(nums,target,true);
        int rightIndex=search(nums,target,false)-1;
        if(leftIndex<=rightIndex && rightIndex<nums.length && nums[leftIndex]==target && nums[rightIndex]==target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }
    public int search(int[] nums, int target,boolean lower) {
        int left =0,right=nums.length-1,ans=nums.length;
        while (left<=right){
            int mid =(left+right)/2;
            if(nums[mid]>target || (lower&& nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
