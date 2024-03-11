package T349两个数组的交集;

import java.sql.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] nums1={1,2,2,1};
        int [] nums2={2,2};
        Solution solution=new Solution();
        System.out.println(solution.intersection(nums1, nums2).toString());
    }

    //排序，双指针遍历
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List list = new ArrayList<Integer>();
        int i=0,j=0;
        while (true){
            if(i>= nums1.length || j>=nums2.length){
                break;
            }
            if(nums1[i]<nums2[j] || (i>0 && nums1[i]==nums1[i-1])){
                i++;
            }else if(nums1[i]>nums2[j] || (j>0 && nums2[j]==nums2[j-1])){
                j++;
            }else if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int [] arr =new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k]= (int) list.get(k);
        }
        return arr;
    }

    //采用哈希集合存储元素可以在O(1)的时间内判断一个元素是否在集合中
    public int[] intersectionSet(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for(int a : nums1){
            hashSet1.add(a);
        }
        for(int a : nums2){
            hashSet2.add(a);
        }
        HashSet<Integer> hashSet3 = new HashSet<>();
        for (int a : hashSet1) {
            if(hashSet2.contains(a)){
                hashSet3.add(a);
            }
        }
        int [] arr=new int[hashSet3.size()];
        int n=0;
        for (int a :hashSet3) {
            arr[n]=a;
            n++;
        }
        return arr;
    }
}
