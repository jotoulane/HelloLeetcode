package main

import (
	"fmt"
	"sort"
)

func main() {
	nums1 := []int{1, 2, 2, 1}
	nums2 := []int{2, 2}
	ints := intersection(nums1, nums2)
	fmt.Printf("%v\n", ints)
}

// 排序，双指针遍历
func intersection(nums1 []int, nums2 []int) []int {
	sort.Ints(nums1)
	sort.Ints(nums2)
	var arr []int
	var i, j int = 0, 0
	for {
		if i >= len(nums1) || j >= len(nums2) {
			break
		}
		if nums1[i] < nums2[j] || (i > 0 && nums1[i] == nums1[i-1]) {
			i++
		} else if nums1[i] > nums2[j] || (j > 0 && nums2[j] == nums2[j-1]) {
			j++
		} else if nums1[i] == nums2[j] {
			arr = append(arr, nums1[i])
			i++
			j++
		}
	}
	return arr
}
