package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestPartitionList(t *testing.T) {
	l0 := &ListNode{Val: 1, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}
	l2 := &ListNode{Val: 2, Next: &ListNode{Val: 6}}
	ans := &ListNode{Val: 1, Next: &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: &ListNode{Val: 6}}}}}}}}
	assert.Equal(t, mergeKLists([]*ListNode{l0, l1, l2}), ans)
}

func TestSolveNQueen(t *testing.T) {
	assert.Equal(t, solveNQueens(4), [][]string{[]string{".Q..", "...Q", "Q...", "..Q."}, []string{"..Q.", "Q...", "...Q", ".Q.."}})
}
func Test4(t *testing.T) {
	assert.Equal(t, 0.0, findMedianSortedArrays([]int{0, 0, 0, 0, 0}, []int{-1, 0, 0, 0, 0, 0, 1}))
	assert.Equal(t, 2.0, findMedianSortedArrays([]int{}, []int{2}))
	assert.Equal(t, 0.0, findMedianSortedArrays([]int{0, 0, 0}, []int{0, 0}))
	assert.Equal(t, 0.0, findMedianSortedArrays([]int{0, 0}, []int{0, 0}))
	assert.Equal(t, 5.5, findMedianSortedArrays([]int{1, 3, 5, 7, 9}, []int{2, 4, 6, 8, 10}))
	assert.Equal(t, 2.0, findMedianSortedArrays([]int{1, 3}, []int{2}))
	assert.Equal(t, 2.5, findMedianSortedArrays([]int{1, 2}, []int{3, 4}))
	assert.Equal(t, 3.0, findMedianSortedArrays([]int{1, 2, 3}, []int{4, 5}))
}
func Test76(t *testing.T) {
	assert.Equal(t, "aa", minWindow("aa", "aa"))
	assert.Equal(t, "ba", minWindow("bba", "ab"))
	assert.Equal(t, "BANC", minWindow("ADOBECODEBANC", "ABC"))
	assert.Equal(t, "a", minWindow("a", "a"))
	assert.Equal(t, "", minWindow("a", "aa"))
}
func TestXx(t *testing.T) {
	//nums := []int{1, 2, 3, 3, 5, 6, 7}
	//assert.Equal(t, 2, sort.Search(6, func(i int) bool {
	//	return nums[i] >= 3
	//}))
	//assert.Equal(t, 4, sort.Search(6, func(i int) bool {
	//	return nums[i] > 3
	//}))
	//assert.Equal(t, 1, sort.Search(6, func(i int) bool {
	//	return nums[i] > 1
	//}))
	//assert.Equal(t, 0, SearchRight(6, func(i int) bool {
	//	return nums[i] < 1
	//}))
	//assert.Equal(t, 1, SearchRight(6, func(i int) bool {
	//	return nums[i] < 3
	//}))
	//assert.Equal(t, 0, SearchRight(6, func(i int) bool {
	//	return nums[i] < 2
	//}))
	//assert.Equal(t, 3, SearchRight(6, func(i int) bool {
	//	return nums[i] < 5
	//}))
	//sort.Search()
	//assert.Equal(t, 5, SearchRight(6, func(i int) bool {
	//	return i < 6 && nums[i] < 7
	//}))
}

func SearchRight(n int, f func(int) bool) int {
	l, r := 0, n
	for l < r {
		mid := l + (r-l)/2
		if !f(mid) {
			r = mid - 1
		} else {
			l = mid
		}
	}
	return l
}
