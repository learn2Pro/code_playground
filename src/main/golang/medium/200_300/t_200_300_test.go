package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test216(t *testing.T) {
	assert.Equal(t, combinationSum3(3, 9), [][]int{{1, 2, 6}, {1, 3, 5}, {2, 3, 4}})

}

func Test287(t *testing.T) {
	assert.Equal(t, 2, findDuplicate([]int{1, 3, 4, 2, 2}))
}

func Test275(t *testing.T) {
	assert.Equal(t, 1, hIndex([]int{100}))
	assert.Equal(t, 3, hIndex([]int{100, 101, 200}))
	assert.Equal(t, 1, hIndex([]int{1, 2}))
	assert.Equal(t, 0, hIndex([]int{0}))
}

func Test209(t *testing.T) {
	assert.Equal(t, 3, minSubArrayLen(11, []int{1, 2, 3, 4, 5}))
	assert.Equal(t, 1, minSubArrayLen(4, []int{1, 4, 4}))
	assert.Equal(t, 2, minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
	assert.Equal(t, 0, minSubArrayLen(11, []int{1, 1, 1, 1, 1, 1, 1, 1}))
}

func Test215(t *testing.T) {
	assert.Equal(t, 5, findKthLargest([]int{3, 2, 1, 5, 6, 4}, 2))
}
