package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 508. Most Frequent Subtree Sum
  */
object _508_MostFreqSubTreeSum {
  def findFrequentTreeSum(root: TreeNode): Array[Int] = {
    val holder = new java.util.HashMap[Int, Int]
    
    def accumulate(node: TreeNode): Int = {
      if (node == null) return 0
      var sum = node.value
      sum += (accumulate(node.left) + accumulate(node.right))
      holder.put(sum, holder.getOrDefault(sum, 0) + 1)
      sum
    }
    
    accumulate(root)
    import scala.collection.JavaConversions._
    var max = 0
    holder.values().foreach(item => max = Math.max(max, item))
    holder.toArray.filter(_._2 == max).map(_._1)
  }
}