package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test327(t *testing.T) {
	assert.Equal(t, 3, countRangeSum([]int{-2, 5, -1}, -2, 2))
	assert.Equal(t, 1, countRangeSum([]int{0}, 0, 0))
}

func Test315(t *testing.T) {
	assert.Equal(t, []int{2, 1, 1, 0}, countSmaller([]int{5, 2, 6, 1}))
}

func Test312(t *testing.T) {
	assert.Equal(t, 167, maxCoins([]int{3, 1, 5, 8}))
}
