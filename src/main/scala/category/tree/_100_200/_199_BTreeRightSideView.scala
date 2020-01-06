package category.tree._100_200


/**
  * 199. Binary Tree Right Side View
  */

import category.timeline.week29.TreeNode

object _199_BTreeRightSideView {
  def rightSideView(root: TreeNode): List[Int] = {
    if (root == null) return Nil
    if (root.left == null && root.right == null) List(root.value)
    else if (root.left != null && root.right != null) {
      val l = rightSideView(root.left)
      val r = rightSideView(root.right)
      val merge = if (l.size > r.size) r ++ l.drop(r.size) else r
      root.value :: merge
    }
    else if (root.right != null) root.value :: rightSideView(root.right)
    else root.value :: rightSideView(root.left)
  }
}