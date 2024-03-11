package T162寻找峰值;

public class Solution {
    public static void main(String[] args) {
        int []nums=new int[]{1,2,3,1};
        int peakElement = new Solution().findPeakHa(nums);
        System.out.println(peakElement);
    }
    //爬山
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
//    时间复杂度：O(logn)
//    空间复杂度：O(1)

    public int findPeakHa(int[] nums) {
        for (int i=0;i<nums.length;i++){
            boolean flag=true;
            if(i-1>=0 && nums[i]<nums[i-1]){
                flag=false;
            }
            if(i+1<nums.length && nums[i]<nums[i+1]){
                flag=false;
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
