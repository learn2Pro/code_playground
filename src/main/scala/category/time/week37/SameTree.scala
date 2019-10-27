package category.time.week37

import category.time.week29.TreeNode

/**
  * 100. Same Tree
  */
object SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) return true
    if (p == null && q != null) return false
    if (p != null && q == null) return false
    p._value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }
}