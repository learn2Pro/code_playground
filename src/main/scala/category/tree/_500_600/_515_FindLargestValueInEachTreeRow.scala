package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 515. Find Largest Value in Each Tree Row
  */
object _515_FindLargestValueInEachTreeRow {
  def largestValues(root: TreeNode): List[Int] = {
    var ans: List[Int] = Nil
    if (root == null) return ans
    val queue = new java.util.LinkedList[TreeNode]()
    queue.add(root)
    while (!queue.isEmpty) {
      val len = queue.size()
      var max = Int.MinValue
      for (_ <- 0 until len) {
        val head = queue.remove()
        max = Math.max(max, head.value)
        if (head.left != null) queue.add(head.left)
        if (head.right != null) queue.add(head.right)
      }
      ans ++= List(max)
    }
    ans
  }
}