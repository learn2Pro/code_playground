package category.tree._200_300

import category.timeline.week29.TreeNode

/**
  * 257. Binary Tree Paths
  */
object _257_BTreePaths {
  def binaryTreePaths(root: TreeNode): List[String] = {
    var ans: List[String] = Nil
    
    def backTrack(node: TreeNode, previous: String): Unit = {
      if (node == null) return
      if (node.left == null && node.right == null) {
        val path = if (previous.isEmpty) node.value.toString else previous + "->" + node.value
        ans ::= path
        return
      }
      val path = if (previous.isEmpty) node.value.toString else previous + "->" + node.value
      backTrack(node.right, path)
      backTrack(node.left, path)
    }
    
    backTrack(root, "")
    ans
  }
}