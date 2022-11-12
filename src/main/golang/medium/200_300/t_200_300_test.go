package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test216(t *testing.T) {
	assert.Equal(t, combinationSum3(3, 9), [][]int{{1, 2, 6}, {1, 3, 5}, {2, 3, 4}})

}
