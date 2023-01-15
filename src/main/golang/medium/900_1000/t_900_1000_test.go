package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test994(t *testing.T) {
	assert.Equal(t, 4, orangesRotting([][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}))
}

func Test912(t *testing.T) {
	assert.Equal(t, []int{1, 2, 3, 5}, sortArray([]int{5, 2, 3, 1}))
}
func Test990(t *testing.T) {
	assert.Equal(t, false, equationsPossible([]string{"a==b", "b!=a"}))
}

func Test969(t *testing.T) {
	assert.Equal(t, []int{3, 4, 2, 3, 2}, pancakeSort([]int{3, 2, 4, 1}))
}
