package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1004(t *testing.T) {
	assert.Equal(t, 6, longestOnes([]int{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2))
	assert.Equal(t, 10, longestOnes([]int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3))
	assert.Equal(t, 0, longestOnes([]int{0, 0, 0}, 0))
	assert.Equal(t, 1, longestOnes([]int{0, 0, 0}, 1))
}

func Test1094(t *testing.T) {
	assert.Equal(t, true, carPooling([][]int{{5, 4, 7}, {7, 4, 8}, {4, 1, 8}}, 17))
	assert.Equal(t, true, carPooling([][]int{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11))
	assert.Equal(t, false, carPooling([][]int{{2, 1, 5}, {3, 3, 7}}, 4))
	assert.Equal(t, true, carPooling([][]int{{2, 1, 5}, {3, 3, 7}}, 5))
	assert.Equal(t, true, carPooling([][]int{{2, 1, 5}, {3, 5, 7}}, 3))
}
func Test1008(t *testing.T) {
	assert.Equal(t, &TreeNode{}, bstFromPreorder([]int{8, 5, 1, 7, 10, 12}))
}
