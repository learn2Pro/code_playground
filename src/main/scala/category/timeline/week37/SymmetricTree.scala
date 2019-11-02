package category.timeline.week37

import category.timeline.week29.TreeNode

/**
  * 101. Symmetric Tree
  */
object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {
    //reverse
    val other = transformDown(root, (node: TreeNode) => {
      val newly = new TreeNode(node.value)
      newly.left = node.right
      newly.right = node.left
      newly
    })
    compare(root, other)
  }

  private def compare(first: TreeNode, other: TreeNode): Boolean = {
    if (first == null && other == null) return true
    if ((first == null && other != null) || (first != null && other == null)) return false
    first.value == other.value && compare(first.left, other.left) && compare(first.right, other.right)
  }


  /**
    * pre-order
    */
  private def transformDown(node: TreeNode, f: TreeNode => TreeNode): TreeNode = {
    if (node == null) return node
    val updated = f.apply(node)
    val left = transformDown(updated.left, f)
    val right = transformDown(updated.right, f)
    updated.left = left
    updated.right = right
    updated
  }
}