package main

func longestConsecutive(nums []int) int {
	m := make(map[int]bool)
	for i := range nums {
		m[nums[i]] = true
	}

	long := 0
	for key, _ := range m {
		if !m[key-1] {
			len := 1
			for m[key+1] {
				len++
				key++
			}
			if len > long {
				long = len
			}
		}
	}

	return long
}
