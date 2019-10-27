package category.time.week37

import category.time.week29.TreeNode

/**
  * 108. Convert Sorted Array to Binary Search Tree
  */
object Sorted2BST {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    
    def buildInRange(start: Int, end: Int): TreeNode = {
      if (start > end) return null
      if (start == end) return new TreeNode(nums(start))
      val mid = start + (end - start + 1) / 2
      val node = new TreeNode(nums(mid))
      node.left = buildInRange(start, mid - 1)
      node.right = buildInRange(mid + 1, end)
      node
    }
    
    buildInRange(0, nums.length - 1)
  }
}