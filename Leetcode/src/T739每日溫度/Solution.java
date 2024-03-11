package T739每日溫度;

import java.util.Stack;

public class Solution {
//给定一个整数数组 temperatures ，表示每天的温度，
// 返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr=new int[temperatures.length];
        Stack<Integer> stack=new Stack();
        for (int i=0;i<temperatures.length;i++) {
            while (stack.size()>0 && temperatures[i]>temperatures[stack.peek()]){
                int preIndex = stack.pop();
                arr[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return arr;
    }
}
