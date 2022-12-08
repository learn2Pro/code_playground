package medium

import (
	"sort"
	"strconv"
	"strings"
)

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Codec struct {
	SEP string
}

func Constructor1() Codec {
	return Codec{SEP: ","}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	var preorder []string
	var pre func(node *TreeNode)
	pre = func(node *TreeNode) {
		if node == nil {
			return
		}
		preorder = append(preorder, strconv.Itoa(node.Val))
		pre(node.Left)
		pre(node.Right)
	}
	pre(root)
	return strings.Join(preorder, this.SEP)
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	items := strings.Split(data, this.SEP)
	var preorder []int
	var inorder []int
	if len(data) > 0 {
		for _, item := range items {
			num, _ := strconv.Atoi(item)
			preorder = append(preorder, num)
			inorder = append(inorder, num)
		}
	}
	sort.Ints(inorder)
	var j int
	var deser func(l, r int) *TreeNode
	deser = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		var idx = -1
		for i := l; i <= r; i++ {
			if inorder[i] == preorder[j] {
				idx = i
				break
			}
		}
		node := &TreeNode{Val: preorder[j]}
		j++
		node.Left, node.Right = deser(l, idx-1), deser(idx+1, r)
		return node
	}
	return deser(0, len(preorder)-1)
}
