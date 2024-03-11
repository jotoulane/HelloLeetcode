package main

import "fmt"

func main() {
	arr := []int{3, 2, 3, 1, 2, 4, 5, 5, 6}
	arr = quicksort(arr)
	fmt.Printf("arr:%v\n", arr)
}

func quicksort(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}
	pivot := arr[0]
	var left, right []int
	for _, ele := range arr[1:] {
		if ele >= pivot {
			left = append(left, ele)
		} else {
			right = append(right, ele)
		}
	}
	return append(quicksort(left), append([]int{pivot}, quicksort(right)...)...)
}
