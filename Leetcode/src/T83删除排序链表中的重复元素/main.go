package T83删除排序链表中的重复元素

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	a := head
	for a.Next != nil {
		if a.Val == a.Next.Val {
			a.Next = a.Next.Next
		} else {
			a = a.Next
		}
	}
	return head
}
