package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 617. Merge Two Binary Trees
  */
object _617_MergeTwoBTree {
  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if (t1 == null && t2 == null) return null
    val (newly, l0, l1, r0, r1) = if (t1 != null && t2 == null) (new TreeNode(t1.value), t1.left, null, t1.right, null)
                                  else if (t1 == null && t2 != null) (new TreeNode(t2.value), null, t2.left, null, t2.right)
                                  else (new TreeNode(t1.value + t2.value), t1.left, t2.left, t1.right, t2.right)
    
    newly.left = mergeTrees(l0, l1)
    newly.right = mergeTrees(r0, r1)
    newly
  }
}