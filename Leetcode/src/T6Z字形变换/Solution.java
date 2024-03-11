package T6Z字形变换;

public class Solution {
    public static void main(String[] args) {
        String s ="PAYPALISHIRING";
        System.out.println(new Solution().convert(s, 3));

    }
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        int index = 0;
        char[][] arr = new char[numRows][s.length()];
        int x = 0;
        int y = 0;
        while (index < s.length()) {
            while (x<numRows && y%(numRows-1)==0 && index < s.length()){
                arr[x][y]=s.charAt(index);
                index++;
                if(x<numRows-1){
                    x++;
                }else {
                    x--;
                    y++;
                }
            }
            while(y%(numRows-1)!=0 && index < s.length()){
                arr[x][y]=s.charAt(index);
                index++;
                x--;
                y++;
            }
        }
        String result = "";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(arr[i][j]>0){
                    result=result+arr[i][j];
                }
            }
        }
        return result;
    }
}
