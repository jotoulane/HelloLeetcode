package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	// 读取输入
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)
	params := strings.Fields(input)

	n, _ := strconv.Atoi(params[0])
	p, _ := strconv.ParseFloat(params[1], 64)

	input, _ = reader.ReadString('\n')
	input = strings.TrimSpace(input)
	qualities := strings.Fields(input)

	// 将品质数组排序
	qualityInts := make([]int, n)
	for i, q := range qualities {
		qualityInts[i], _ = strconv.Atoi(q)
	}
	sort.Ints(qualityInts)

	// 使用二分查找计算最大x
	low, high := 0, qualityInts[n-1]
	maxX := 0

	for low <= high {
		mid := (low + high) / 2
		// 计算当前x的概率
		prob := calculateProbability(qualityInts, mid)

		if prob >= p {
			maxX = mid
			low = mid + 1
		} else {
			high = mid - 1
		}
	}

	fmt.Println(maxX)
}

// 计算当前x的概率
func calculateProbability(qualities []int, x int) float64 {
	count := 0
	for _, quality := range qualities {
		if quality >= x {
			count++
		}
	}
	return float64(count) / float64(len(qualities))
}
