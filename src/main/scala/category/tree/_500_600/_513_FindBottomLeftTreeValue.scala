package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 513. Find Bottom Left Tree Value
  */
object _513_FindBottomLeftTreeValue {
  def findBottomLeftValue(root: TreeNode): Int = {
    var theLast: Int = root.value
    val queue = new java.util.LinkedList[TreeNode]()
    queue.add(root)
    while (!queue.isEmpty) {
      val len = queue.size()
      for (i <- 0 until len) {
        val head = queue.remove()
        if (i == 0) theLast = head.value
        if (head.left != null) queue.add(head.left)
        if (head.right != null) queue.add(head.right)
      }
    }
    theLast
  }
}