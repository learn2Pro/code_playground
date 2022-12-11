package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1631(t *testing.T) {
	assert.Equal(t, 2, minimumEffortPath([][]int{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}))
}
func Test1696(t *testing.T) {
	assert.Equal(t, 0, maxResult([]int{1, -5, -20, 4, -1, 3, -6, -3}, 2))
}
