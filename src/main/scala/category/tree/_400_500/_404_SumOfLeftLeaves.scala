package category.tree._400_500

import category.timeline.week29.TreeNode

/**
  * 404. Sum of Left Leaves
  */
object _404_SumOfLeftLeaves {
  def sumOfLeftLeaves(root: TreeNode): Int = {
    def leftLeaves(node: TreeNode, left: Boolean): Int = {
      if (node == null) return 0
      if (node.left == null && node.right == null && left) return node.value
      leftLeaves(node.left, true) + leftLeaves(node.right, false)
    }
    
    leftLeaves(root, false)
  }
}