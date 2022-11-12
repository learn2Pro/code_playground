package medium

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func distanceK(root *TreeNode, target *TreeNode, k int) []int {
	var parent = make(map[int]*TreeNode)
	var ans []int
	var buildParent func(node *TreeNode)
	buildParent = func(node *TreeNode) {
		if node == nil {
			return
		}
		if node.Left != nil {
			parent[node.Left.Val] = node
			buildParent(node.Left)
		}
		if node.Right != nil {
			parent[node.Right.Val] = node
			buildParent(node.Right)
		}
	}
	var searchKAns func(node *TreeNode, from *TreeNode, step int)
	searchKAns = func(node *TreeNode, from *TreeNode, step int) {
		if node == nil {
			return
		}
		if k == step {
			ans = append(ans, node.Val)
		}
		if node.Left != from {
			searchKAns(node.Left, node, step+1)
		}
		if node.Right != from {
			searchKAns(node.Right, node, step+1)
		}
		if parent[node.Val] != from {
			searchKAns(parent[node.Val], node, step+1)
		}

	}
	buildParent(root)
	searchKAns(target, nil, 0)
	return ans
}

func distanceK1(root *TreeNode, target *TreeNode, k int) []int {
	var ans []int
	var findKDistance func(node *TreeNode)
	findKDistance = func(node *TreeNode) {
		step := 0
		var q = []*TreeNode{node}
		for len(q) > 0 {
			var size = len(q)
			var tmp []*TreeNode
			for i := 0; i < size; i++ {
				if step == k {
					ans = append(ans, q[i].Val)
				}
				if q[i].Left != nil && step != k {
					tmp = append(tmp, q[i].Left)
				}
				if q[i].Right != nil && step != k {
					tmp = append(tmp, q[i].Right)
				}
			}
			step++
			q = tmp
		}
	}
	var makeTargetBeRoot func(node *TreeNode) *TreeNode
	makeTargetBeRoot = func(node *TreeNode) *TreeNode {
		if node == nil || node == target {
			return node
		}
		left := makeTargetBeRoot(node.Left)
		if left != nil {
			if left.Left == nil {
				left.Left, node.Left = node, nil
			} else {
				left.Right, node.Left = node, nil
			}
			return node
		}
		right := makeTargetBeRoot(node.Right)
		if right != nil {
			if right.Left == nil {
				right.Left, node.Right = node, nil
			} else {
				right.Right, node.Right = node, nil
			}
			return node
		}
		return nil
	}

	if k == 0 {
		return []int{target.Val}
	}
	findKDistance(target) //find target node child
	target.Left = nil
	target.Right = nil
	makeTargetBeRoot(root) //make target be the root
	findKDistance(target)
	return ans
}
