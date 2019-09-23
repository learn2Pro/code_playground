package week38

import week29.TreeNode


/**
  * 113. Path Sum II
  */
object PathSumII {
  
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    remainPathSum(root, sum, Nil, Nil)
  }
  
  def remainPathSum(root: TreeNode, sum: Int, ans: List[List[Int]], mid: List[Int]): List[List[Int]] = {
    if (root == null) return Nil
    if (sum == root.value && root.left == null && root.right == null) {
      return (mid ++ List(sum)) :: ans
    }
    remainPathSum(root.left, sum - root.value, ans, mid ++ List(root.value))
    remainPathSum(root.right, sum - root.value, ans, mid ++ List(root.value))
  }
}