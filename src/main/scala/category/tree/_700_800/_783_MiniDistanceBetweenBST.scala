package category.tree._700_800

import category.timeline.week29.TreeNode

/**
  * 783. Minimum Distance Between BST Nodes
  */
object _783_MiniDistanceBetweenBST {
  def minDiffInBST(root: TreeNode): Int = {
    var ans: Long = Int.MaxValue
    
    def inOrder(node: TreeNode): (Long, Long) = {
      if (node == null) return (Int.MaxValue, Int.MinValue)
      val (l0, l1) = inOrder(node.left)
      val (r0, r1) = inOrder(node.right)
      ans = Math.min(ans, Math.min(Math.abs(node.value - l1), Math.abs(node.value - r0)))
      (Math.min(l0, node.value), Math.max(node.value, r1))
    }
    
    inOrder(root)
    ans.toInt
  }
}