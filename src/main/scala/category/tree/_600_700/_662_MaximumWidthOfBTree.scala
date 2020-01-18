package category.tree._600_700

import category.timeline.week29.TreeNode


/**
  * 662. Maximum Width of Binary Tree
  */
object _662_MaximumWidthOfBTree {
  
  
  def widthOfBinaryTree(root: TreeNode): Int = {
    val leftPos = new java.util.HashMap[Int, Int]
    var width = 0
    
    def dfs(node: TreeNode, depth: Int, pos: Int): Unit = {
      if (node == null) return
      if (!leftPos.containsKey(depth)) leftPos.put(depth, pos)
      width = Math.max(width, pos - leftPos.get(depth) + 1)
      dfs(node.left, depth + 1, 2 * pos)
      dfs(node.right, depth + 1, 2 * pos + 1)
    }
    
    dfs(root, 0, 0)
    width
  }
}