package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test491(t *testing.T) {
	assert.Equal(t, [][]int{{4, 4}}, findSubsequences([]int{4, 4, 3, 2, 1}))
}

func Test424(t *testing.T) {
	assert.Equal(t, 2, characterReplacement("ABAA", 0))
	assert.Equal(t, 1, characterReplacement("ABA", 0))
	assert.Equal(t, 5, characterReplacement("AAAAA", 2))
	assert.Equal(t, 4, characterReplacement("ABAB", 2))
	assert.Equal(t, 4, characterReplacement("AABABBA", 1))
}

func Test449(t *testing.T) {
	codec := Constructor()
	assert.Equal(t, nil, codec.deserialize(codec.serialize(nil)))
}
