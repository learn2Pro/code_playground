package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test113(t *testing.T) {
	node := &TreeNode{Val: 5, Left: &TreeNode{Val: 4, Left: &TreeNode{Val: 11, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 2}}}, Right: &TreeNode{Val: 8, Left: &TreeNode{Val: 13}, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 1}}}}
	assert.Equal(t, pathSum(node, 22), [][]int{{5, 4, 11, 2}, {5, 8, 4, 5}})
}

func Test153(t *testing.T) {
	assert.Equal(t, 1, findMin([]int{4, 5, 1, 2, 3}))
}

func Test151(t *testing.T) {
	assert.Equal(t, "blue is sky the", reverseWords("the sky is blue"))
}

func Test130(t *testing.T) {
	//[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
	//input := [][]byte{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}}
	//solve(input)
	//assert.Equal(t, [][]byte{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}}, input)
	input := [][]byte{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}}
	solve(input)
	assert.Equal(t, [][]byte{{'O', 'X', 'X', 'O', 'X'}, {'X', 'X', 'X', 'X', 'O'}, {'X', 'X', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}}, input)
}

func Test146(t *testing.T) {
	//lru := Constructor(2)
	//lru.Put(1, 1)
	//lru.Put(2, 2)
	//assert.Equal(t, 1, lru.Get(1))
	//lru.Put(3, 3)
	//assert.Equal(t, -1, lru.Get(2))
	//lru.Put(4, 4)
	//assert.Equal(t, -1, lru.Get(1))
	//assert.Equal(t, 3, lru.Get(3))
	//assert.Equal(t, 4, lru.Get(4))
	lru := Constructor(2)
	lru.Put(2, 1)
	lru.Put(3, 2)
	assert.Equal(t, 2, lru.Get(3))
	assert.Equal(t, 1, lru.Get(2))
	lru.Put(4, 3)
	assert.Equal(t, 1, lru.Get(2))
	assert.Equal(t, -1, lru.Get(3))
	assert.Equal(t, 3, lru.Get(4))
}
