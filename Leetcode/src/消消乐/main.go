package main

import (
	"fmt"
)

// 假设你要设计一个一维的消消乐游戏
// 整数代表糖果的颜色 nums=[0,0,0,5,5,5,5,5,0,6,6,7,7,7,7]
// 规则：如果连续相同颜色糖果数量>=k个，那么这一段连续的糖果都可以消除，前后相接
// 要求：写一个函数，输入nums，k，输出消除后剩下的数组

func eliminate(nums []int, k int) []int {
	// 用一个栈来存储糖果的颜色和数量
	stack := make([][2]int, 0)
	// 遍历数组
	for _, num := range nums {
		// 如果栈为空或者栈顶颜色和当前颜色不同，那么就把当前颜色和数量入栈
		if len(stack) == 0 || stack[len(stack)-1][0] != num {
			stack = append(stack, [2]int{num, 1})
		} else {
			// 如果栈顶颜色和当前颜色相同，那么就把栈顶的数量加1
			stack[len(stack)-1][1]++
			// 如果栈顶的数量等于k，并且下一个颜色和栈顶颜色不同，那么就把栈顶弹出，如果下一个颜色和栈顶颜色相同，那么继续向栈顶添加元素
			if stack[len(stack)-1][1] == k {
				stack = stack[:len(stack)-1]
			}
		}
	}
	// 遍历栈，把栈中的颜色和数量转换成数组
	result := make([]int, 0)
	for _, item := range stack {
		for i := 0; i < item[1]; i++ {
			result = append(result, item[0])
		}
	}
	return result
}

func main() {
	nums := []int{0, 0, 0, 5, 5, 5, 5, 5, 0, 6, 6, 7, 7, 7, 7}
	k := 3
	result := eliminate(nums, k)
	fmt.Println("剩余的数组：", result)
}
