package T496下一个更大的元素;

import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            int j=0;
            while(nums1[i]!=nums2[j]){
                j++;
            }
            for (  ;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    res[i]=nums2[j];
                    break;
                }
                res[i]=-1;
            }
        }
        return res;
    }
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map =new HashMap<>();
        for (int i=0;i<nums2.length;i++){
            while ( stack.size()>0 && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);    //删除栈顶，并返回删除元素的值
            }
            stack.push(nums2[i]);
        }
        int[] res=new int[nums1.length];
        for (int i=0;i< nums1.length;i++){
            res[i]=map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
