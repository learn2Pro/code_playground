package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test140(t *testing.T) {
	assert.Equal(t, wordBreak1("catsanddog", []string{"cat", "cats", "and", "sand", "dog"}), []string{"cats and dog", "cat sand dog"})
}

func Test154(t *testing.T) {
	assert.Equal(t, 2, findMin([]int{2, 2, 2}))
	assert.Equal(t, 0, findMin([]int{2, 2, 2, 0, 1}))
}
