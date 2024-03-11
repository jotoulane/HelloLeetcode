package main

import "fmt"

var symbolValue = map[byte]int{'I': 1, 'V': 5, 'X': 10,
	'L': 50, 'C': 100, 'D': 500, 'M': 1000}

func romanToInt(s string) int {
	n := len(s)
	res := 0
	for i, _ := range s {
		value := symbolValue[s[i]]
		if i < n-1 && value < symbolValue[s[i+1]] {
			res -= value
		} else {
			res += value
		}
	}
	return res
}

func main() {
	toInt := romanToInt("MCMXCIV")
	fmt.Printf("toInt:%v\n", toInt)
}
