package category.tree._200_300

import category.tree.TreeNode


/**
  * 222. Count Complete Tree Nodes
  */
object _222_CountCompleteTreeNodes {
  def countNodes(root: TreeNode): Int = {
    import scala.annotation.tailrec
    
    @tailrec
    def level(node: TreeNode, size: Int = -1): Int = {
      if (node == null) return size
      level(node.left, size + 1)
    }
    
    if (root == null) return 0
    val maxLevel = level(root)
    //    var earlyStop = false
    if (maxLevel < 0) 0 else {
      if (level(root.right) == maxLevel - 1) (1 << maxLevel) + countNodes(root.right)
      else (1 << (maxLevel - 1)) + countNodes(root.left)
    }
    
    //    def missed(node: TreeNode, level: Int, count: Int): Int = {
    //      if (earlyStop) return count
    //      if (node != null && level == maxLevel) return count
    //      if (node == null && level == maxLevel) return count + 1
    //      val update0 = missed(node.right, level + 1, count)
    //      if (update0 == count) earlyStop = true
    //      val update1 = missed(node.left, level + 1, update0)
    //      if (update1 == update0) earlyStop = true
    //      update1
    //    }
    //
    //    Math.pow(2, maxLevel + 1).toInt - 1 - missed(root, 0, 0)
  }
}