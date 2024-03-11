package T169多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer , Integer> result = new HashMap();
        int n = nums.length;
        for (int i = 0 ; i < n ; i++) {
            int num = result.getOrDefault(nums[i] , 0) + 1;
            // 如果某个数字出现的个数已经超过数组的一半，返回结果
            if (num > n / 2) {
                return nums[i];
            }
            result.put(nums[i], num);
        }
        return -1;
    }
}
