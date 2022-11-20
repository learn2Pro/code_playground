package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1300(t *testing.T) {
	assert.Equal(t, 5, findBestValue([]int{2, 3, 5}, 10))
	assert.Equal(t, 3, findBestValue([]int{4, 9, 3}, 10))
}

func Test1283(t *testing.T) {
	assert.Equal(t, 5, smallestDivisor([]int{1, 2, 5, 9}, 6))
	assert.Equal(t, 44, smallestDivisor([]int{44, 22, 33, 11, 1}, 5))
	assert.Equal(t, 1, smallestDivisor([]int{1}, 5))
	assert.Equal(t, 9, smallestDivisor([]int{44}, 5))
}

func Test1292(t *testing.T) {
	assert.Equal(t, 2, maxSideLength([][]int{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}}, 4))
	assert.Equal(t, 0, maxSideLength([][]int{{2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}}, 1))
	assert.Equal(t, 1, maxSideLength([][]int{{10, 1, 11}, {10, 2, 12}, {10, 3, 13}}, 6))
}
