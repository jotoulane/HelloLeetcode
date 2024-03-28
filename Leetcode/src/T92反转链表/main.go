package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	for head != nil {
		next := head.Next
		head.Next = prev
		prev = head
		head = next
	}
	return prev
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummyNode := &ListNode{Val: -1}
	dummyNode.Next = head

	prev := dummyNode
	for i := 0; i < left-1; i++ {
		prev = prev.Next
	}

	rightNode := prev
	for i := 0; i < right-left+1; i++ {
		rightNode = rightNode.Next
	}

	leftNode := prev.Next
	curr := rightNode.Next

	prev.Next = nil
	rightNode.Next = nil

	reverseList(leftNode)

	prev.Next = rightNode
	leftNode.Next = curr
	return dummyNode.Next
}
