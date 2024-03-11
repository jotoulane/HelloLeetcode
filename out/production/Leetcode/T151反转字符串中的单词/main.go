package main

import (
	"fmt"
)

func main() {
	words := reverseWords("  hello world  ")
	fmt.Printf("words:%v\n", words)
}

func reverseWords(s string) string {
	arr := make([]string, 0)
	temp := ""
	for i := 0; i < len(s); i++ {
		//fmt.Printf("s[i]:%v\n", string(s[i]))
		if s[i] == ' ' {
			if len(temp) == 0 {
				continue
			} else {
				//fmt.Printf("temp:%v,len:%v\n", temp, len(temp))
				arr = append(arr, temp)
				temp = ""
			}
		} else {
			temp += string(s[i])
		}
	}
	if temp != "" {
		arr = append(arr, temp)
	}
	//fmt.Printf("arr:%v\n", arr)
	//fmt.Printf("len(arr):%v\n", len(arr))

	str := ""
	for i := len(arr) - 1; i >= 0; i-- {
		str += arr[i] + " "
	}
	str = str[:len(str)-1]
	return str
}
