package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 653. Two Sum IV - Input is a BST
  */
object _653_TwoSumIVBST {
  def findTarget(root: TreeNode, k: Int): Boolean = {
    val nums = new java.util.HashSet[Int]
    var found = false
    
    def traversal(node: TreeNode): Unit = {
      if (found) return
      if (node == null) return
      if (nums.contains(k - node.value)) {
        nums.add(node.value)
        found = true
      } else {
        nums.add(node.value)
        traversal(node.left)
        traversal(node.right)
      }
    }
    
    traversal(root)
    found
  }
}