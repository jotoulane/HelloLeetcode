package main

import (
	"fmt"
)

func main() {
	//intervals := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
	intervals := [][]int{{1, 4}, {4, 5}}
	res := merge(intervals)
	fmt.Printf("res:%v\n", res)
}
func merge(intervals [][]int) [][]int {
	resArr := make([][]int, 0)
	prev := intervals[0]
	for i := 1; i < len(intervals); i++ {
		cur := intervals[i]
		if prev[1] < cur[0] {
			resArr = append(resArr, prev)
			prev = cur
		} else {
			prev[1] = max(prev[1], cur[1])
		}
	}
	resArr = append(resArr, prev)
	return resArr
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
