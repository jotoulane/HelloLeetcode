package main

import (
	"fmt"
	"strconv"
)

func main() {
	num1 := "123"
	num2 := "456"

	s := multiply(num1, num2)
	fmt.Printf("s:%v\n", s)
}

func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}
	result := make([]int, len(num1)+len(num2))
	for i, n1 := range num1 {
		for j, n2 := range num2 {
			result[i+j+1] += int(n1-'0') * int(n2-'0')
		}
	}
	for i := len(result) - 1; i > 0; i-- {
		if result[i] > 9 {
			result[i-1] += result[i] / 10
			result[i] = result[i] % 10
		}
	}
	if result[0] == 0 {
		result = result[1:]
	}
	var str string
	for i, _ := range result {
		str += strconv.Itoa(result[i])
	}
	return str
}
