package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test1845(t *testing.T) {
	s := Constructor(5)
	assert.Equal(t, 1, s.Reserve())
	assert.Equal(t, 2, s.Reserve())
	s.Unreserve(2)
	assert.Equal(t, 2, s.Reserve())
	assert.Equal(t, 3, s.Reserve())
	assert.Equal(t, 4, s.Reserve())
	assert.Equal(t, 5, s.Reserve())
	s.Unreserve(5)
}
