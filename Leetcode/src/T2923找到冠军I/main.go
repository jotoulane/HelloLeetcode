package main

func main() {

}

func find(grid [][]int) int {
next:
	for i, row := range grid {
		for j, x := range row {
			if j != i && x == 0 {
				continue next
			}
		}
		return i
	}
	return -1
}

func findChampion(grid [][]int) int {
	ans := 0
	for i, row := range grid {
		if row[ans] == 1 {
			ans = i
		}
	}
	return ans
}
