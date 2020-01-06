package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 563. Binary Tree Tilt
  */
object _563_BTreeTilt {
  def findTilt(root: TreeNode): Int = {
    var ans = 0
    
    def backTrack(node: TreeNode): Int = {
      if (node == null) return 0
      val l = backTrack(node.left)
      val r = backTrack(node.right)
      ans += Math.abs(l - r)
      l + r + node.value
    }
    
    backTrack(root)
    ans
  }
}