package main

import "container/heap"

func main() {

}

type IntHeap []int

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Less(i, j int) bool {
	return h[i] < h[j]
}
func (h IntHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	x := old[len(old)-1]
	*h = old[:len(old)-1]
	return x
}

func findKthLargest01(nums []int, k int) int {
	h := IntHeap(nums[:k])
	heap.Init(&h)

	for i := k; i < len(nums); i++ {
		heap.Push(&h, nums[i])
		heap.Pop(&h)
	}
	return h[0]
}
