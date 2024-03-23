package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	dfs(&res, root)
	return res
}

func dfs(res *[]int, root *TreeNode) {
	if root == nil {
		return
	}
	dfs(res, root.Left)
	*res = append(*res, root.Val)
	dfs(res, root.Right)
}

func main() {
	// 示例代码，创建一棵二叉树进行测试
	root := &TreeNode{Val: 1}
	root.Right = &TreeNode{Val: 2}
	root.Right.Left = &TreeNode{Val: 3}

	result := inorderTraversal(root)
	fmt.Println(result) // 输出中序遍历结果
}
