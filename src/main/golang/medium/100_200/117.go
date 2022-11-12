package medium

//Node Definition for a Node.
type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return root
	}
	var q = []*Node{root}
	for len(q) > 0 {
		size := len(q)
		var tmp []*Node
		var curr *Node
		for i := 0; i < size; i++ {
			if i > 0 {
				curr.Next = q[i]
			}
			if q[i].Left != nil {
				tmp = append(tmp, q[i].Left)
			}
			if q[i].Right != nil {
				tmp = append(tmp, q[i].Right)
			}
			curr = q[i]
		}
		q = tmp
	}
	return root
}
