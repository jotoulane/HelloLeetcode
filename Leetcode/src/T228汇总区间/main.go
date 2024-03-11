package main

import (
	"fmt"
	"strconv"
)

func main() {
	//nums := []int{0, 1, 2, 4, 5, 7}
	//nums := []int{0, 2, 3, 4, 6, 8, 9}
	nums := []int{-1}
	ranges := summaryRanges(nums)
	fmt.Printf("ranges:%v\n", ranges)
}

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}
	if len(nums) == 1 {
		return []string{strconv.Itoa(nums[0])}
	}
	arr := make([]string, 0)
	left := 0
	right := 0
	for i := 0; i < len(nums)-1; i++ {
		//fmt.Printf("left:%v\n", nums[left])
		//fmt.Printf("right:%v\n", nums[right])
		if nums[i+1]-nums[i] == 1 {
			right = i + 1
		} else {
			if left != right {
				arr = append(arr, fmt.Sprintf("%v->%v", nums[left], nums[right]))
			} else {
				arr = append(arr, fmt.Sprintf("%v", nums[right]))
			}
			left = i + 1
			right = i + 1
		}
	}
	if left == right {
		arr = append(arr, fmt.Sprintf("%v", nums[right]))
	} else {
		arr = append(arr, fmt.Sprintf("%v->%v", nums[left], nums[right]))
	}
	//fmt.Printf("left:%v\n", left)
	//fmt.Printf("right:%v\n", right)
	//fmt.Printf("len(nums):%v\n", len(nums))
	return arr
}
