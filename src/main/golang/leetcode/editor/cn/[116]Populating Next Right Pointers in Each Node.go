package lc

//Node Definition for a Node.
type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect1(root *Node) *Node {
	if root == nil {
		return root
	}
	var q = []*Node{root}
	for len(q) > 0 {
		var tmp []*Node
		n := len(q)
		for i := 0; i < n; i++ {
			if i+1 < n {
				q[i].Next = q[i+1]
			}
			if q[i].Left != nil {
				tmp = append(tmp, q[i].Left)
			}
			if q[i].Right != nil {
				tmp = append(tmp, q[i].Right)
			}
		}
		q = tmp
	}
	return root
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
	if root == nil {
		return root
	}
	var traversal func(node0 *Node, node1 *Node)
	traversal = func(node0 *Node, node1 *Node) {
		if node0 == nil || node1 == nil {
			return
		}
		node0.Next = node1
		traversal(node0.Left, node0.Right)
		traversal(node1.Left, node1.Right)
		traversal(node0.Right, node1.Left)
	}
	traversal(root.Left, root.Right)
	return root
}

//leetcode submit region end(Prohibit modification and deletion)
