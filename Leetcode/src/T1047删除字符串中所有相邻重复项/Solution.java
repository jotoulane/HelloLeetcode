package T1047删除字符串中所有相邻重复项;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(new Solution().removeDuplicates(s));
    }
    public String removeDuplicates(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if ( stack.size()!=0 && stack.getLast().equals(c) ){
                stack.removeLast();
            }else {
                stack.add(c);
            }
        }
        String s1="";
        while (stack.size()>0){
            s1+=stack.removeFirst();
        }
        return s1;
    }
}
