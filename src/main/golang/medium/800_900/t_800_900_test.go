package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test863(t *testing.T) {
	target := &TreeNode{Val: 5, Left: &TreeNode{Val: 6}, Right: &TreeNode{Val: 2, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 4}}}
	root := &TreeNode{Val: 3, Left: target, Right: &TreeNode{Val: 1, Left: &TreeNode{Val: 0}, Right: &TreeNode{Val: 8}}}
	assert.Equal(t, []int{7, 4, 1}, distanceK(root, target, 2))
	target = &TreeNode{Val: 2, Right: &TreeNode{Val: 3, Right: &TreeNode{Val: 4}}}
	root = &TreeNode{Val: 0, Right: &TreeNode{Val: 1, Left: target, Right: &TreeNode{Val: 5}}}
	assert.Equal(t, []int{4, 0, 5}, distanceK(root, target, 2))
}
