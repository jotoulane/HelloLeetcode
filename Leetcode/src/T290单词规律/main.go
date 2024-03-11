package main

import (
	"fmt"
	"strings"
)

func main() {
	pattern := "abba"
	s := "dog cat cat dog"
	b := wordPattern(pattern, s)
	fmt.Printf("b:%v\n", b)
}

func wordPattern(pattern string, s string) bool {
	pMap := make(map[byte]string)
	sMap := make(map[string]byte)
	split := strings.Split(s, " ")
	if len(pattern) != len(split) {
		return false
	}
	for i := range split {
		p, w := pattern[i], split[i]
		if a, ok := pMap[p]; ok {
			if a != w {
				return false
			}
		}
		if a, ok := sMap[w]; ok {
			if a != p {
				return false
			}
		}
		pMap[p] = w
		sMap[w] = p
	}
	return true
}
