package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test773(t *testing.T) {
	assert.Equal(t, 1, slidingPuzzle([][]int{{1, 2, 3}, {4, 0, 5}}))
}
