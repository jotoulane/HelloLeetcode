package T5最长回文子串;

public class Solution {
    public static void main(String[] args) {
        String s ="babad";
        System.out.println(new Solution().longestPalindrome1(s));
    }
    //双指针
    public String longestPalindrome(String s) {
        int mid = 0;
        int left=0;
        int right=0;
        int maxStart=0;
        int maxLength=0;
        for (mid = 0; mid < s.length(); mid++) {
            int length=1;
            left=mid-1;
            right=mid+1;
            //左右指针与中间指针相同的情况之下，相同侧的指针继续移动
            while(left>=0 && s.charAt(left)==s.charAt(mid)) {
                length++;
                left--;
            }
            while(right<=s.length()-1 && s.charAt(right)==s.charAt(mid)) {
                length++;
                right++;
            }
            while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)) {
                length+=2;
                right++;
                left--;
            }
            if(length>maxLength){
                maxLength=length;
                maxStart=left;
            }
        }
        return s.substring(maxStart+1,maxStart+maxLength+1);
    }
    //动态规划
    public String longestPalindrome1(String s) {
        int maxStart=0;
        int maxEnd=0;
        int maxLen=1;
        boolean [][] dp =new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(j)==s.charAt(i) && ( i-j<=2 || dp[j+1][i-1] )){
                    dp[j][i]=true;
                    if(i-j+1>maxLen){
                        maxLen=i-j+1;
                        maxStart=j;
                        maxEnd=i;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}