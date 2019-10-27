package category.time.week38

import category.time.week29.TreeNode


/**
  * 124. Binary Tree Maximum Path Sum
  */
object BTreeMaxPathSum {
  
  import scala.collection.mutable.ArrayBuffer
  
  def maxPathSum(root: TreeNode): Int = {
    val ans = new ArrayBuffer[Long]()
    pathSum(root, ans)
    ans.max.toInt
  }
  
  def pathSum(root: TreeNode, buffer: ArrayBuffer[Long]): Long = {
    if (root == null) return Int.MinValue
    else if (root.left == null && root.right == null) {
      buffer += root.value
      return root.value
    }
    
    val left = pathSum(root.left, buffer)
    val right = pathSum(root.right, buffer)
    val treeSum = left + right + root.value
    val leftSum = left + root.value
    val rightSum = right + root.value
    
    val ans = Math.max(root.value, Math.max(leftSum, rightSum))
    buffer += Math.max(Math.max(ans, treeSum), Math.max(left, right))
    ans
  }
  
}