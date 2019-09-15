package week37

import week29.TreeNode

/**
  * 101. Symmetric Tree
  */
object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {

  }


  /**
    * pre-order
    */
  private def transformDown(node: TreeNode, f: TreeNode => TreeNode): TreeNode = {
    if (node == null) return node
    val updated = f.apply(node)
    transformDown(updated.left, f)
    transformDown(updated.right, f)
    updated
  }
}