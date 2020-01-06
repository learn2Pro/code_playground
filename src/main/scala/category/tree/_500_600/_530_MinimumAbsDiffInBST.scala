package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 530. Minimum Absolute Difference in BST
  */
object _530_MinimumAbsDiffInBST {
  def getMinimumDifference(root: TreeNode): Int = {
    var min = Int.MaxValue
    
    def inOrder(node: TreeNode): (Int, Int) = {
      if (node == null) return (Int.MaxValue, Int.MinValue)
      if (node.left == null && node.right == null) return (node.value, node.value)
      val l = inOrder(node.left)
      val r = inOrder(node.right)
      min = Math.min(min, Math.abs(node.value - l._2.toLong)).toInt
      min = Math.min(min, Math.abs(node.value - r._1.toLong)).toInt
      (Math.min(node.value, l._1), Math.max(r._2, node.value))
    }
    
    inOrder(root)
    min
  }
}