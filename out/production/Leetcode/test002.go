package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)
	monsters := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&monsters[i])
	}

	sort.Sort(sort.Reverse(sort.IntSlice(monsters)))

	courage := 0
	power := 0

	for i := 0; i < n; i++ {
		if power < monsters[i] {
			courage += monsters[i] - power
			power = monsters[i]
		}
		power--
	}

	fmt.Println(courage)
}
