package T34在排序数组查找第一和最后一个位置;

public class MySolution {
    public static void main(String[] args) {
        int []arr=new int[]{5,7,7,8,8,10};
        int tar=8;
        int[] ints = new MySolution().searchRange(arr, tar);
        for (int a :ints
             ) {
            System.out.print(a+" ");
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int l = searchLeft(nums, left, right, target);
        int r = searchRight(nums, left, right, target);
        return new int[]{l,r};
    }
    int searchLeft(int[] nums,int left,int right,int tar){
        while (left<=right){
            int mid=(right+left)/2;
            if(nums[mid]>=tar){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(left>=nums.length || nums[left]!=tar){
            return -1;
        }
        return left;
    }
    int searchRight(int[] nums,int left,int right,int tar){
        while (left<=right){
            int mid=(right+left)/2;
            if(nums[mid]<=tar){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(right<0 || nums[right]!=tar){
            return -1;
        }
        return right;
    }
}
