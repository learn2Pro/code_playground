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
