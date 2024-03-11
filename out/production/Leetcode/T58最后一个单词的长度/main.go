package main

func main() {

}

func lengthOfLastWord(s string) int {
	index := len(s) - 1
	var ans int
	//去除末尾空格
	for s[index] == ' ' {
		index--
	}
	for index >= 0 && s[index] != ' ' {
		ans++
		index--
	}
	return ans
}
