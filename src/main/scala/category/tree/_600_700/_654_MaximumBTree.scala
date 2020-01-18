package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 654. Maximum Binary Tree
  */
object _654_MaximumBTree {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    val stack = new java.util.LinkedList[TreeNode]
    nums.foreach { num =>
      val node = new TreeNode(num)
      while (!stack.isEmpty && stack.getFirst.value < num) {
        node.left = stack.pop()
      }
      if (!stack.isEmpty) {
        stack.getFirst.right = node
      }
      stack.push(node)
    }
    stack.getLast
  }
  
  def constructMaximumBinaryTreeV1(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) return null
    var max, idx, maxIdx = 0
    nums.foreach { num =>
      if (num > max) {
        max = num
        maxIdx = idx
      }
      idx += 1
    }
    val node = new TreeNode(max)
    node.left = constructMaximumBinaryTree(nums.slice(0, maxIdx))
    node.right = constructMaximumBinaryTree(nums.slice(maxIdx + 1, nums.length))
    node
  }
}