package week38

import week29.TreeNode

/**
  * 112. Path Sum
  */
object PathSum {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if (root == null) return false
    if (sum == root.value && root.left == null && root.right == null) return true
    hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
  }
  
}