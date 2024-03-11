package T88合并两个有序数组

func merge(nums1 []int, m int, nums2 []int, n int) {
	nums := make([]int, 0, m+n)
	p1, p2 := 0, 0
	for {
		if p1 == m {
			nums = append(nums, nums2[p2:]...)
			break
		}
		if p2 == n {
			nums = append(nums, nums1[p1:]...)
		}
		if nums1[p1] < nums2[p2] {
			nums = append(nums, nums1[p1])
			p1++
		} else {
			nums = append(nums, nums2[p2])
			p2++
		}
	}
	copy(nums1, nums)
}
