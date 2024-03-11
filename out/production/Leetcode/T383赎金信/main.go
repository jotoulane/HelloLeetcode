package main

import "fmt"

func main() {
	ransomNote := "bcjefgecda"
	magazine := "hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh"
	construct := canConstruct(ransomNote, magazine)
	fmt.Printf("construct:%v\n", construct)
}

func canConstruct(ransomNote string, magazine string) bool {
	mMag := make(map[byte]int)
	mRan := make(map[byte]int)
	for i := 0; i < len(magazine); i++ {
		_, boolen := mMag[magazine[i]]
		if boolen {
			mMag[magazine[i]] += 1
		} else {
			mMag[magazine[i]] = 1
		}
	}
	for i := 0; i < len(ransomNote); i++ {
		_, boolen := mRan[ransomNote[i]]
		if boolen {
			mRan[ransomNote[i]] += 1
		} else {
			mRan[ransomNote[i]] = 1
		}
	}
	flag := true
	for key, value := range mMag {
		if value >= mRan[key] {
			continue
		} else {
			return false
		}
	}
	return flag
}
