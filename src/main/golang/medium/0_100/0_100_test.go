package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

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
