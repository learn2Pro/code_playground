package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1631(t *testing.T) {
	assert.Equal(t, 2, minimumEffortPath([][]int{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}))
}
