package category.timeline.week37

import category.timeline.week29.TreeNode

/**
  * 104. Maximum Depth of Binary Tree
  */
object BTreeMaxDepth {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) return 0
    traversalDepth(root, 1)
  }
  
  def traversalDepth(node: TreeNode, level: Int): Int = {
    if (node == null) return level
    val left = traversalDepth(node.left, level + 1)
    val right = traversalDepth(node.right, level + 1)
    Math.max(level, Math.max(left, right))
  }
}