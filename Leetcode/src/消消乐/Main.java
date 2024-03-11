package 消消乐;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] inputArr = {0,0,0,5,5,5,5,5,0,6,6,7,7,7,7}; // Replace this with your desired input array
        int k = 3; // Change this value to set the number of consecutive elements to eliminate

        Stack<Integer> stack = new Stack<>();
        for (int num : inputArr) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                int top = stack.peek();
                if (top == num) {
                    int count = 1;
                    while (!stack.isEmpty() && stack.peek() == num) {
                        stack.pop();
                        count++;
                    }
                    if (count < k) {
                        for (int i = 0; i < count; i++) {
                            stack.push(num);
                        }
                    }
                } else {
                    stack.push(num);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int item : stack) {
            result.append(item).append(" ");
        }
        System.out.println(result.toString());
    }
}
