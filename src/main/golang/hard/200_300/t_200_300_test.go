package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test239(t *testing.T) {
	assert.Equal(t, []int{3, 3, 5, 5, 6, 7}, maxSlidingWindow([]int{1, 3, -1, -3, 5, 3, 6, 7}, 3))
	assert.Equal(t, []int{1}, maxSlidingWindow([]int{1}, 1))
	assert.Equal(t, []int{-1, -1}, maxSlidingWindow([]int{-1, -1}, 1))
}
