package T14最长公共前綴;

class Solution {
    public static void main(String[] args) {
        String [] s={"ab", "a"};
        System.out.println(new Solution().longestCommonPrefix2(s));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int rows=strs.length;
        int cols=strs[0].length();//列
        for(int i=0;i<cols;i++){
            char firstChar =strs[0].charAt(i);
            for(int j=1;j<rows;j++){
                if(strs[j].length()==i || strs[j].charAt(i)!=firstChar){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix=longestCommPre(prefix,strs[i]);
            if(prefix.length()==0)return "";
        }

        return prefix;
    }
    private String longestCommPre(String str1,String str2){
        int len= Math.min(str1.length(),str2.length());
        int index=0;
        while (index<len && str1.charAt(index)== str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}