package main

func main() {

}

func moveZeroes(nums []int) {
	left, right := 0, 0
	length := len(nums)
	for right < length {
		if nums[right] != 0 {
			nums[left], nums[right] = nums[right], nums[left]
			left++
		}
		right++
	}
}
