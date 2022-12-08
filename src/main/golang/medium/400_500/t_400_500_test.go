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
	codec := Constructor1()
	assert.Equal(t, nil, codec.deserialize(codec.serialize(nil)))
}

func Test460(t *testing.T) {
	//lfu := Constructor(2)
	//lfu.Put(1, 1)
	//lfu.Put(2, 2)
	//assert.Equal(t, 1, lfu.Get(1))
	//lfu.Put(3, 3)
	//assert.Equal(t, -1, lfu.Get(2))
	//assert.Equal(t, 3, lfu.Get(3))
	//lfu.Put(4, 4)
	//assert.Equal(t, -1, lfu.Get(1))
	//assert.Equal(t, 3, lfu.Get(3))
	//assert.Equal(t, 4, lfu.Get(4))
	lfu := Constructor(0)
	lfu.Put(0, 0)
	assert.Equal(t, -1, lfu.Get(0))
}
