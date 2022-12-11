package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test514(t *testing.T) {
	assert.Equal(t, 4, findRotateSteps("godding", "gd"))
	assert.Equal(t, 10, findRotateSteps("edcba", "abcde"))
}
