package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test713(t *testing.T) {
	assert.Equal(t, 15, numSubarrayProductLessThanK([]int{1, 1, 1, 1, 2}, 3))
	assert.Equal(t, 0, numSubarrayProductLessThanK([]int{1, 1, 1, 1, 1}, 1))
	assert.Equal(t, 0, numSubarrayProductLessThanK([]int{1}, 1))
	assert.Equal(t, 0, numSubarrayProductLessThanK([]int{1, 2, 3}, 0))
	assert.Equal(t, 8, numSubarrayProductLessThanK([]int{10, 5, 2, 6}, 100))
}

func Test710(t *testing.T) {
	solution := Constructor(7, []int{2, 3, 5})
	assert.Equal(t, 1, solution.Pick())
}

func Test787(t *testing.T) {
	assert.Equal(t, 700, findCheapestPrice(4, [][]int{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1))
}
