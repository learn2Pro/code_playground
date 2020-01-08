package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 623. Add One Row to Tree
  */
object _623_AddOneRowToTree {
  def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {
    
    def backTrack(node: TreeNode, depth: Int): Unit = {
      if (node == null) return
      if (depth < d - 1) {
        backTrack(node.left, depth + 1)
        backTrack(node.right, depth + 1)
        return
      }
      val tmpLeft = node.left
      val tmpRight = node.right
      val newlyLeft = new TreeNode(v)
      val newlyRight = new TreeNode(v)
      node.left = newlyLeft
      node.right = newlyRight
      newlyLeft.left = tmpLeft
      newlyRight.right = tmpRight
    }
    
    if (d == 1) {
      val newly = new TreeNode(v)
      newly.left = root
      return newly
    }
    backTrack(root, 1)
    root
  }
}