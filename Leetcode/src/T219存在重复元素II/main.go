package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 1}
	k := 3
	duplicate := containsNearbyDuplicate(nums, k)
	fmt.Printf("duplicate:%v\n", duplicate)
}

func containsNearbyDuplicate(nums []int, k int) bool {
	n := len(nums)
	set := map[int]bool{}
	for i := 0; i < n; i++ {
		if i > k {
			set[nums[i-k-1]] = false
		}
		if set[nums[i]] {
			return true
		}
		set[nums[i]] = true
	}
	return false
}
