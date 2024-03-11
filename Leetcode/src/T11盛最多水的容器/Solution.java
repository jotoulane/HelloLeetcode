package T11盛最多水的容器;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight=Math.min(height[left],height[right]);
            max = Math.max(max, minHeight*(right-left));
            while(height[left]<=minHeight && left<right){
                left++;
            }
            while(height[right]<=minHeight && left<right){
                right--;
            }
        }
        return max;
    }
}
