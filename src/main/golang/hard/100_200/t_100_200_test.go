package hard

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test140(t *testing.T) {
	assert.Equal(t, wordBreak1("catsanddog", []string{"cat", "cats", "and", "sand", "dog"}), []string{"cats and dog", "cat sand dog"})
}
