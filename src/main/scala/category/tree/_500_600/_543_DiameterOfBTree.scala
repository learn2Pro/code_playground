package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 543. Diameter of Binary Tree
  */
object _543_DiameterOfBTree {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var ans = 1
    
    def depth(node: TreeNode): Int = {
      if (node == null) return 0
      val l = depth(node.left)
      val r = depth(node.right)
      ans = Math.max(ans, l + r + 1)
      Math.max(l, r) + 1
    }
    
    depth(root)
    ans - 1
  }
}