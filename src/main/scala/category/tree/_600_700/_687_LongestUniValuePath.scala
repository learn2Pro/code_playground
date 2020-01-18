package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 687. Longest Univalue Path
  */
object _687_LongestUniValuePath {
  def longestUnivaluePath(root: TreeNode): Int = {
    
    var ans = 0
    
    def dfs(node: TreeNode): Int = {
      if (node == null) return 0
      val l = dfs(node.left)
      val r = dfs(node.right)
      var lSum, rSum = 0
      if (node.left != null && node.left.value == node.value) lSum += (l + 1)
      if (node.right != null && node.right.value == node.value) rSum += (r + 1)
      ans = Math.max(ans, lSum + rSum)
      Math.max(l, r)
    }
    
    if (root == null) return ans
    dfs(root)
    ans
  }
}