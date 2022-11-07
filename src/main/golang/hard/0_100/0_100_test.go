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
