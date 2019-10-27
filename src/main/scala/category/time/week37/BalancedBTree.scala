package category.time.week37

import category.time.week29.TreeNode

/**
  * 110. Balanced Binary Tree
  */
object BalancedBTree {
  def isBalanced(root: TreeNode): Boolean = {
    
    def depth(node: TreeNode, level: Int): Int = {
      if (node == null) return level
      Math.max(depth(node.left, level + 1), depth(node.right, level + 1))
    }
    
    if (root == null) return true
    Math.abs(depth(root.left, 0) - depth(root.right, 0)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right)
  }
  
}