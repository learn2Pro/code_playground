package category.tree._600_700

import category.timeline.week29.TreeNode


/**
  * 637. Average of Levels in Binary Tree
  */
object _637_AvgOfLevelInBTree {
  
  import scala.collection.mutable.ArrayBuffer
  
  def averageOfLevels(root: TreeNode): Array[Double] = {
    val ans = new ArrayBuffer[Double]()
    val queue = new java.util.LinkedList[TreeNode]()
    if (root != null) queue.add(root)
    while (!queue.isEmpty) {
      val len = queue.size()
      var sum, size = 0.0
      for (_ <- 0 until len) {
        val head = queue.remove()
        if (head.left != null) queue.add(head.left)
        if (head.right != null) queue.add(head.right)
        sum += head.value
        size += 1
      }
      ans.append(sum / size)
    }
    ans.toArray
  }
}