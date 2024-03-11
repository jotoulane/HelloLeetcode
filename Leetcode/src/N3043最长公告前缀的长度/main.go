package main

import (
	"fmt"
	"strconv"
)

func main() {
	arr1 := []int{13, 27, 45}
	arr2 := []int{21, 27, 48}
	prefix := longestCommonPrefix(arr1, arr2)
	fmt.Printf("prefix:%v\n", prefix)
}

func longestCommonPrefix(arr1 []int, arr2 []int) int {
	m1 := make(map[string]int, 0)
	for _, item := range arr1 { //
		s := strconv.Itoa(item)
		for i := 1; i <= len(s); i++ {
			m1[s[:i]] = 0
		}
	}
	for _, item := range arr2 {
		str := strconv.Itoa(item)
		for i := 1; i <= len(str); i++ {
			_, b := m1[str[:i]]
			if b {
				m1[str[:i]] = 1
			}
		}
	}
	max := 0
	for key, value := range m1 {
		if value == 1 && len(key) > max {
			max = len(key)
		}
	}
	return max
}
