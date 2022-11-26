package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test862(t *testing.T) {
	assert.Equal(t, 9, shortestSubarray([]int{27, 20, 79, 87, -36, 78, 76, 72, 50, -26}, 453))
	assert.Equal(t, 2, shortestSubarray([]int{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151))
	assert.Equal(t, 3, shortestSubarray([]int{84, -37, 32, 40, 95}, 167))
	assert.Equal(t, 1, shortestSubarray([]int{-2, 2, 2, -2, 2, 2}, 2))
	assert.Equal(t, -1, shortestSubarray([]int{-1, -1, -1, -1}, 1))
	assert.Equal(t, 1, shortestSubarray([]int{-2, 2, -2, 2}, 2))
	assert.Equal(t, 1, shortestSubarray([]int{1}, 1))
	assert.Equal(t, -1, shortestSubarray([]int{1, 2}, 4))
	assert.Equal(t, 3, shortestSubarray([]int{2, -1, 2}, 3))
}
