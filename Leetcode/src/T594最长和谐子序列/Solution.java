package T594最长和谐子序列;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int begin=0;
        int res=0;
        for (int end=0;end<l;end++){
            while ( nums[end]-nums[begin]>1 && end>begin ) begin++;
            if(nums[end]-nums[begin]==1){
                res=Math.max(res,end-begin+1);
            }
        }
        return res;
    }
    public int findLHS2(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int m : map.keySet()) {
            if(map.containsKey(m+1)){
                res=Math.max(res,map.get(m)+map.get(m+1));
            }
        }
        return res;
    }
}
