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
