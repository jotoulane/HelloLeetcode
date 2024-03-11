package main

import (
	"math/rand"
	"time"
)

func main() {
	print(findKthLargest([]int{1, 8, 2, 7, 3, 2, 6, 5, 4}, 1))
}
func findKthLargest(nums []int, k int) int {
	rand.Seed(time.Now().UnixNano())
	return quickSelect(nums, 0, len(nums)-1, len(nums)-k)
}

func quickSelect(nums []int, left, right, targetIndex int) int {
	if left == right {
		return nums[left]
	}
	pivotIndex := randomPartition(nums, left, right)
	if targetIndex == pivotIndex {
		return nums[targetIndex]
	} else if targetIndex < pivotIndex {
		return quickSelect(nums, left, pivotIndex-1, targetIndex)
	} else {
		return quickSelect(nums, pivotIndex+1, right, targetIndex)
	}
}

func randomPartition(nums []int, left, right int) int {
	pivotIndex := rand.Intn(right-left+1) + left
	pivot := nums[pivotIndex]
	nums[pivotIndex], nums[right] = nums[right], nums[pivotIndex]
	i := left - 1
	for j := left; j < right; j++ {
		if nums[j] < pivot {
			i++
			nums[i], nums[j] = nums[j], nums[i]
		}
	}
	nums[i+1], nums[right] = nums[right], nums[i+1]
	return i + 1
}
