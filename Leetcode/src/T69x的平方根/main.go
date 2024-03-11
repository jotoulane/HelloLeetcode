package T69x的平方根

func mySqrt(x int) int {
	if x == 1 {
		return 1
	}
	for i := 0; i <= x; i++ {
		if i*i > x {
			return i - 1
		}
	}
	return 0
}

func mySqrt2(x int) int {
	l, r := 0, x
	ans := 0
	for l <= r {
		mid := l + (r-l)/2
		if mid*mid <= x {
			ans = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	return ans
}
