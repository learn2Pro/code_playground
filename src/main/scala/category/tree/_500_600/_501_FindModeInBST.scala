package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 501. Find Mode in Binary Search Tree
  */
object _501_FindModeInBST {
  def findMode(root: TreeNode): Array[Int] = {
    val holder = new java.util.HashMap[Int, Int]
    
    def traversal(node: TreeNode): Unit = {
      if (node == null) return
      holder.put(node.value, holder.getOrDefault(node.value, 0) + 1)
      traversal(node.left)
      traversal(node.right)
    }
    
    traversal(root)
    import scala.collection.JavaConversions._
    var max = 0
    holder.values().foreach(item => max = Math.max(max, item))
    holder.toArray.filter(_._2 == max).map(_._1)
  }
}