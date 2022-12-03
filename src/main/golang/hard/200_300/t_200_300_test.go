package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test239(t *testing.T) {
	assert.Equal(t, []int{3, 3, 5, 5, 6, 7}, maxSlidingWindow([]int{1, 3, -1, -3, 5, 3, 6, 7}, 3))
	assert.Equal(t, []int{1}, maxSlidingWindow([]int{1}, 1))
	assert.Equal(t, []int{-1, -1}, maxSlidingWindow([]int{-1, -1}, 1))
}

func Test297(t *testing.T) {
	node := &TreeNode{Val: 1, Left: &TreeNode{Val: 2}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 4}, Right: &TreeNode{Val: 5}}}
	codec := Constructor()
	var str = codec.serialize(node)
	println(str)
	codec.deserialize(str)
	assert.Equal(t, "1,2,NULL,NULL,3,4,NULL,NULL,5,NULL,NULL", str)
}
