package main

import (
	"fmt"
	"strings"
)

func main() {
	s := "ababababababab"
	split := strings.Split(s, "a")
	//split := strings.SplitAfterN(s, "b", 0)
	fmt.Printf("s:%v\n", strings.Join(split, "/"))
	//path := "/home/"
	//res := simplifyPath(path)
	//fmt.Printf("res:%v\n", res)
}

func simplifyPath(path string) string {
	ans := []string{}
	for _, s := range strings.Split(path, "/") {
		if s != "" && s != "." && s != ".." {
			ans = append(ans, s)
		} else if s == ".." && len(ans) > 0 {
			ans = ans[:len(ans)-1]
		}
	}
	return "/" + strings.Join(ans, "/")
}
