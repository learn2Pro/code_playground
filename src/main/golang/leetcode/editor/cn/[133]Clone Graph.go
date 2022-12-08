package lc

type Node struct {
	Val       int
	Neighbors []*Node
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Neighbors []*Node
 * }
 */

func cloneGraph(node *Node) *Node {
	visited := make(map[*Node]bool)
	mapping := make(map[*Node]*Node)
	var traversal func(node *Node) *Node
	traversal = func(node *Node) *Node {
		if _, ok := visited[node]; ok {
			return mapping[node]
		}
		visited[node] = true
		copied := &Node{Val: node.Val}
		mapping[node] = copied
		for _, neighbor := range node.Neighbors {
			copied.Neighbors = append(copied.Neighbors, traversal(neighbor))
		}
		return copied
	}
	if node == nil {
		return nil
	}
	return traversal(node)
}

//leetcode submit region end(Prohibit modification and deletion)
