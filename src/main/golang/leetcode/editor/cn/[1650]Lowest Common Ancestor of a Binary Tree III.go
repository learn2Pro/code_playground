package lc

type Node struct {
	Val    int
	Left   *Node
	Right  *Node
	Parent *Node
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Parent *Node
 * }
 */

func lowestCommonAncestor(p *Node, q *Node) *Node {
	visited := make(map[*Node]bool)
	for p != nil {
		visited[p] = true
		p = p.Parent
	}
	for q != nil {
		if visited[q] {
			return q
		}
		q = q.Parent
	}
	return nil
}

//leetcode submit region end(Prohibit modification and deletion)
