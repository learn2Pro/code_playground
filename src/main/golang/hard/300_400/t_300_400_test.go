package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test327(t *testing.T) {
	assert.Equal(t, 3, countRangeSum([]int{-2, 5, -1}, -2, 2))
	assert.Equal(t, 1, countRangeSum([]int{0}, 0, 0))
}
