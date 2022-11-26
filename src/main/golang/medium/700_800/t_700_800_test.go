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
