package main

import (
	"fmt"
)

const MOD = 1000000007

func main() {
	var T int
	fmt.Scan(&T)

	for t := 0; t < T; t++ {
		var n, k int

		// 输入长度n和子串长度k
		fmt.Scan(&n, &k)

		// 初始化动态规划数组
		dp := make([][]int, n+1)
		for i := range dp {
			dp[i] = make([]int, 2)
		}

		// 初始化dp数组
		dp[0][0] = 1
		dp[0][1] = 0

		// 计算dp数组
		for i := 1; i <= n; i++ {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD
			dp[i][1] = dp[i-1][0]

			if i >= k {
				dp[i][1] = (dp[i][1] - dp[i-k][0] + MOD) % MOD
			}
		}

		// 计算与S不同的二进制位串的数量
		diffCount := (dp[n][0] + dp[n][1]) % MOD

		// 输出结果
		fmt.Println(diffCount)
	}
}
