package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1329(t *testing.T) {
	//[[3,3,1,1],[2,2,1,2],[1,1,1,2]]
	assert.Equal(t, [][]int{{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}}, diagonalSort([][]int{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}))
}

//4
//[1,-1,3,-1]
//[2,-1,-1,-1]
//4
//[1,-1,3,-1]
//[2,3,-1,-1]
//2
//[1,0]
//[-1,-1]
//6
//[1,-1,-1,4,-1,-1]
//[2,-1,-1,5,-1,-1]
func Test1361(t *testing.T) {
	assert.Equal(t, false, validateBinaryTreeNodes(2, []int{1, 0}, []int{-1, -1}))
	assert.Equal(t, true, validateBinaryTreeNodes(4, []int{1, -1, 3, -1}, []int{2, -1, -1, -1}))
	assert.Equal(t, false, validateBinaryTreeNodes(4, []int{1, -1, 3, -1}, []int{2, 3, -1, -1}))
}
