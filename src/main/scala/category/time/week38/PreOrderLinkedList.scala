package category.time.week38

import category.time.week29.TreeNode

/**
  * 114. Flatten Binary Tree to Linked List
  */
object PreOrderLinkedList {
  def flatten(root: TreeNode): Unit = {
    if (root == null) return
    linkNow(root)
  }
  
  def linkNow(node: TreeNode): (TreeNode, TreeNode) = {
    if (node == null) return (null, null)
    if (node.left == null && node.right == null) return (node, node)
    val (leftStart, leftEnd) = linkNow(node.left)
    val (rightStart, rightEnd) = linkNow(node.right)
    node.left = null
    if (leftStart == null && leftEnd == null) {
      node.right = rightStart
      (node, rightEnd)
    } else {
      node.right = leftStart
      leftEnd.right = rightStart
      if (rightEnd == null) (node, leftEnd)
      else (node, rightEnd)
    }
  }
}