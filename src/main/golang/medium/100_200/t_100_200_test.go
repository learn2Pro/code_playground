package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test113(t *testing.T) {
	node := &TreeNode{Val: 5, Left: &TreeNode{Val: 4, Left: &TreeNode{Val: 11, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 2}}}, Right: &TreeNode{Val: 8, Left: &TreeNode{Val: 13}, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 1}}}}
	assert.Equal(t, pathSum(node, 22), [][]int{{5, 4, 11, 2}, {5, 8, 4, 5}})
}

func Test153(t *testing.T) {
	assert.Equal(t, 1, findMin([]int{4, 5, 1, 2, 3}))
}

func Test151(t *testing.T) {
	assert.Equal(t, "blue is sky the", reverseWords("the sky is blue"))
}
