package category.tree._400_500

import category.timeline.week29.TreeNode

/**
  * 437. Path Sum III
  */
object _437_PathSumIII {
  def pathSum(root: TreeNode, sum: Int): Int = {
    val pathSumMap = new java.util.HashMap[Int, Int]
    pathSumMap.put(0, 1)
    
    def traversal(node: TreeNode, accumulate: Int, target: Int): Int = {
      if (node == null) return 0
      val currentSum = accumulate + node.value
      var ans = pathSumMap.getOrDefault(currentSum - target, 0)
      pathSumMap.put(currentSum, pathSumMap.getOrDefault(currentSum, 0) + 1)
      ans += traversal(node.left, currentSum, target) + traversal(node.right, currentSum, target)
      pathSumMap.put(currentSum, pathSumMap.getOrDefault(currentSum, 0) - 1)
      ans
    }
    
    traversal(root, 0, sum)
  }
  
  //  def pathSum(root: TreeNode, sum: Int): Int = {
  //
  //    def traversal(node: TreeNode, sum: Int, onTheWay: Boolean): Int = {
  //      if (node == null) return 0
  //      val incr = if (node.value == sum) 1 else 0
  //      if (onTheWay) {
  //        incr + traversal(node.left, sum - node.value, true) +
  //                traversal(node.right, sum - node.value, true)
  //      } else {
  //        incr + traversal(node.left, sum, onTheWay) +
  //                traversal(node.right, sum, onTheWay) +
  //                traversal(node.left, sum - node.value, true) +
  //                traversal(node.right, sum - node.value, true)
  //      }
  //    }
  //
  //    traversal(root, sum, false)
  //  }
}