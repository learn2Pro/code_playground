package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test7(t *testing.T) {
	assert.Equal(t, -2143847412, reverse(-2147483412))
	assert.Equal(t, -321, reverse(-123))
}
func TestRemoveNthFromEnd(t *testing.T) {
	l0 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: &ListNode{Val: 2}}}}}}
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 5}}}}
	assert.Equal(t, removeNthFromEnd(l0, 2), l1)
}

func TestPartitionList(t *testing.T) {
	l0 := &ListNode{Val: 1, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3, Next: &ListNode{Val: 2, Next: &ListNode{Val: 5, Next: &ListNode{Val: 2}}}}}}
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 2, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3, Next: &ListNode{Val: 5}}}}}}
	assert.Equal(t, partition(l0, 3), l1)
}

func TestAddTwoNumber(t *testing.T) {
	var l0 = ListNode{Val: 2, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3}}}
	var l1 = ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4}}}
	assert.Equal(t, addTwoNumbers(&l0, &l1), &ListNode{Val: 7, Next: &ListNode{Val: 0, Next: &ListNode{Val: 8}}})

	l0 = ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
		Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
			Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
				Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
					Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
						Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
							Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
								Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4,
									Next: &ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4}}}}}}}}}}}}}}}}}}}}}}}}}}}
	l1 = ListNode{Val: 5, Next: &ListNode{Val: 6, Next: &ListNode{Val: 4}}}
	addTwoNumbers(&l0, &l1)
}

func TestLengthOfLongest(t *testing.T) {
	assert.Equal(t, lengthOfLongestSubstring("abcabcbb"), 3)
}

func Test22(t *testing.T) {
	assert.Equal(t, generateParenthesis(1), []string{"()"})
}

func Test15(t *testing.T) {
	assert.Equal(t, [][]int{[]int{0, 0, 0}}, threeSum([]int{0, 0, 0}))
}

func Test96(t *testing.T) {
	assert.Equal(t, 5, numTrees(3))
}

func Test13(t *testing.T) {
	assert.Equal(t, 1994, romanToInt("MCMXCIV"))
}
