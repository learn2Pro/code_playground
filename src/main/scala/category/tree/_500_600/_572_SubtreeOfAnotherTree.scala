package category.tree._500_600


import category.timeline.week29.TreeNode

/**
  * 572. Subtree of Another Tree
  */
object _572_SubtreeOfAnotherTree {
  def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
    var target: String = null
    var find: Boolean = false
    
    def inOrder(node: TreeNode): String = {
      if (find) return ""
      if (node == null) return ""
      val str = inOrder(node.left) + node.value + inOrder(node.right)
      if (str == target) find = true
      str
    }
    
    target = inOrder(t)
    inOrder(s)
    find
  }
}