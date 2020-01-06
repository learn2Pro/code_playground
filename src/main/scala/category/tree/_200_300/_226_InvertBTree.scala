package category.tree._200_300

import category.tree.TreeNode

/**
  * 226. Invert Binary Tree
  */
object _226_InvertBTree {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return root
    val tmp = root.left
    root.left = root.right
    root.right = tmp
    invertTree(root.left)
    invertTree(root.right)
    root
  }
}