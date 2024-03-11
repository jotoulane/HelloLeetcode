package T209长度最小的子数组;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int low = 0, high = 0, min = Integer.MAX_VALUE;
        while (high < nums.length) {
            target -= nums[high];
            high++;
            while (target <= 0) {
                min = Math.min(min, high - low);
                target += nums[low];
                low++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
