package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 669. Trim a Binary Search Tree
  */
object _669_TrimABST {
  def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
    
    if (root == null) return root
    if (root.value < L) return trimBST(root.right, L, R)
    if (root.value > R) return trimBST(root.left, L, R)
    root.left = trimBST(root.left, L, R)
    root.right = trimBST(root.right, L, R)
    root
  }
}