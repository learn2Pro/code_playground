package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1329(t *testing.T) {
	//[[3,3,1,1],[2,2,1,2],[1,1,1,2]]
	assert.Equal(t, [][]int{{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}}, diagonalSort([][]int{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}))
}
