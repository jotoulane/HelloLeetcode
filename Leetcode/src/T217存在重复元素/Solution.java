package T217存在重复元素;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return true;
            }else {
                map.put(nums[i],nums[i]);
            }
        }
        return false;
    }
}
