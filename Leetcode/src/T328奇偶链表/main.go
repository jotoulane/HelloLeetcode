package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	// 如果链表为空，则直接返回空
	if head == nil {
		return head
	}
	// 初始化偶数链表头节点为原链表第二个节点
	evenHead := head.Next
	// 初始化奇数节点为链表头节点
	odd := head
	// 初始化偶数节点为偶数链表头节点
	even := head.Next
	// 循环直到偶数节点为空或者偶数节点的下一个节点为空
	for even != nil && even.Next != nil {
		// 奇数节点的下一个节点指向偶数节点的下一个节点
		odd.Next = even.Next
		// 奇数节点指向下一个奇数节点
		odd = odd.Next
		// 偶数节点的下一个节点指向奇数节点的下一个节点
		even.Next = odd.Next
		// 偶数节点指向下一个偶数节点
		even = even.Next
	}
	// 将奇数节点的末尾指向偶数链表的头节点，完成奇偶链表的连接
	odd.Next = evenHead
	// 返回原链表的头节点
	return head
}

func main() {
	list := oddEvenList(&ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: nil}}}}})

	for list != nil {
		fmt.Printf("%v ", list.Val)
		list = list.Next
	}
}
