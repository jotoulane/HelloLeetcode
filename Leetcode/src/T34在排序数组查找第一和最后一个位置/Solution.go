package main

func main() {

}

func searchRange(nums []int, target int) []int {
	left := 0
	right := len(nums) - 1
	l := searchLeft(nums, left, right, target)
	r := searchRight(nums, left, right, target)
	return []int{l, r}
}
func searchLeft(nums []int, left int, right int, tar int) int {
	for left <= right {
		mid := (right + left) / 2
		if nums[mid] >= tar {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	if left >= len(nums) || nums[left] != tar {
		return -1
	}
	return left
}

func searchRight(nums []int, left int, right int, tar int) int {
	for left <= right {
		mid := (right + left) / 2
		if nums[mid] <= tar {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	if right < 0 || nums[right] != tar {
		return -1
	}
	return right
}
