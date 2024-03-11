package T26删除有序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0;
        int b = 1;
        while (b < nums.length) {
            if (nums[a] != nums[b]){
                nums[a+1]=nums[b];
                a++;
            }
            b++;
        }
        return a;
    }
}
