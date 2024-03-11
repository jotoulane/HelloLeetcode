package main

func main() {

}

func jump(nums []int) int {
	res := 0
	for i := len(nums) - 1; i > 0; {
		for j := 0; j < len(nums); j++ {
			if nums[j] >= i-j {
				i = j
				res++
				break
			}
		}
	}
	return res
}
