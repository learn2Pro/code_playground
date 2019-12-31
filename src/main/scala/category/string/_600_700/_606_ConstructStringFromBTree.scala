package category.string._600_700

import category.timeline.week29.TreeNode

/**
  * 606. Construct String from Binary Tree
  */
object _606_ConstructStringFromBTree {
  
  def tree2str(t: TreeNode): String = {
    if (t == null) return "()"
    if (t.left == null && t.right == null) return t.value.toString
    if (t.right == null && t.left != null) return s"${t.value}(${tree2str(t.left)})"
    if (t.right != null && t.left == null) return s"${t.value}()(${tree2str(t.right)})"
    s"${t.value}(${tree2str(t.left)})(${tree2str(t.right)})"
  }
}