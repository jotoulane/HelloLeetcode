package main

import "fmt"

// TreeNode 表示二叉树节点
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countSpecialPaths(root *TreeNode) int {
	if root == nil {
		return 0
	}

	// 定义一个变量用于记录路径数目
	count := 0

	// 辅助函数，递归遍历二叉树
	var dfs func(*TreeNode, int, int)
	dfs = func(node *TreeNode, ones, zeros int) {
		if node == nil {
			return
		}

		// 更新当前路径上的权值1和权值0的个数
		if node.Val == 1 {
			ones++
		} else {
			zeros++
		}

		// 当遇到叶子节点时，检查路径是否符合条件
		if node.Left == nil && node.Right == nil {
			if ones == zeros+1 {
				count++
			}
		}

		// 递归遍历左子树和右子树
		dfs(node.Left, ones, zeros)
		dfs(node.Right, ones, zeros)
	}

	// 从根节点开始递归遍历
	dfs(root, 0, 0)

	return count
}

func main() {
	// 构造示例二叉树
	root := &TreeNode{
		Val: 0,
		Left: &TreeNode{
			Val:  1,
			Left: &TreeNode{Val: 1},
			Right: &TreeNode{
				Val:   0,
				Left:  &TreeNode{Val: 1},
				Right: &TreeNode{Val: 0},
			},
		},
		Right: &TreeNode{
			Val:   0,
			Right: &TreeNode{Val: 0},
		},
	}

	result := countSpecialPaths(root)
	fmt.Println("路径数目:", result)
}
