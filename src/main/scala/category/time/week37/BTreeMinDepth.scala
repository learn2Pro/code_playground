package category.time.week37

import category.time.week29.TreeNode

/**
  *111. Minimum Depth of Binary Tree
  */
object BTreeMinDepth {
  def minDepth(root: TreeNode): Int = {
    
    def depth(node: TreeNode, level: Int): Int = {
      if (node == null) return level
      val leftDepth = depth(node.left, level + 1)
      val rightDepth = depth(node.right, level + 1)
      if (leftDepth == level + 1 && rightDepth != level + 1) rightDepth
      else if (leftDepth != level + 1 && rightDepth == level + 1) leftDepth
      else if (leftDepth != level + 1 && rightDepth != level + 1) Math.min(leftDepth, rightDepth)
      else level + 1
    }
    
    depth(root, 0)
    
  }
}