package main

import (
	"fmt"
	"sort"
)

func main() {
	citations := []int{3, 0, 6, 1, 5}
	index := hIndex(citations)
	fmt.Printf("index:%v\n", index)
}

func hIndex(citations []int) int {
	var n int
	sort.Ints(citations)
	for i := len(citations) - 1; i >= 0 && citations[i] > n; i-- {
		n++
	}
	return n
}
