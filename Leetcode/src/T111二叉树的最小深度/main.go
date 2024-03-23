package main

func main() {

}

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func minDepth(root *TreeNode) int {

	if root == nil {
		return 0
	}

	if root.Left == nil && root.Right == nil {
		return 1
	}

	leftMin := minDepth(root.Left)
	rightMin := minDepth(root.Right)

	if root.Left == nil {
		return rightMin + 1
	} else if root.Right == nil {
		return leftMin + 1
	} else {
		return min(leftMin, rightMin) + 1
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

/*
https://leetcode.cn/problems/minimum-depth-of-binary-tree/solutions/2268496/cong-jian-dan-di-gui-dao-dfs-he-bfs-by-y-fqmj
*/
