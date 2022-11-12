package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test491(t *testing.T) {
	assert.Equal(t, [][]int{{4, 4}}, findSubsequences([]int{4, 4, 3, 2, 1}))
}
