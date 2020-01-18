package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 671. Second Minimum Node In a Binary Tree
  */
object _671_SecondMinimumNodeInBTree {
  def findSecondMinimumValue(root: TreeNode): Int = {
    if (root == null) return -1
    val maxValue = root.value
    
    def minWithOutMax(a: Int, b: Int): Int = {
      if (a == maxValue) return b
      if (b == maxValue) return a
      Math.min(a, b)
    }
    
    def dfs(node: TreeNode): Int = {
      if (node == null) return maxValue
      minWithOutMax(node.value, minWithOutMax(dfs(node.left), dfs(node.right)))
    }
    
    val ans = dfs(root)
    if (ans == maxValue) -1 else ans
    
  }
}