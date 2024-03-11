package T3无重复字符的最长子串;

public class Solution {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i), flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }
    //https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/4354/javati-jie-3wu-zhong-fu-zi-fu-de-zui-chang-zi-chua/
}