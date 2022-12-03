package hard

import (
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
	SEP  string
	NULL string
}

func Constructor() Codec {
	return Codec{
		SEP:  ",",
		NULL: "#",
	}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	var ans []string
	var preorder func(node *TreeNode)
	preorder = func(node *TreeNode) {
		if node == nil {
			ans = append(ans, this.NULL)
			return
		}
		ans = append(ans, strconv.Itoa(node.Val))
		preorder(node.Left)
		preorder(node.Right)
	}
	preorder(root)
	return strings.Join(ans, this.SEP)
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	splits := strings.Split(data, this.SEP)
	var j int
	var build func() *TreeNode
	build = func() *TreeNode {
		curr := splits[j]
		if curr == this.NULL {
			j++
			return nil
		}
		num, _ := strconv.Atoi(curr)
		node := &TreeNode{Val: num}
		j++
		node.Left, node.Right = build(), build()
		return node
	}
	return build()
}
