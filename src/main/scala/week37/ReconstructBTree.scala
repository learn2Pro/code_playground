package week37

import week29.TreeNode

/**
  * 105. Construct Binary Tree from Preorder and Inorder Traversal
  */
object ReconstructBTree {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    var pIndex = 0
    val location = inorder.zipWithIndex.toMap
    
    def buildInRange(start: Int, end: Int): TreeNode = {
      if (start > end) return null
      val node = new TreeNode(preorder(pIndex))
      pIndex += 1
      val pivot = location(node.value)
      node.left = buildInRange(start, pivot - 1)
      node.right = buildInRange(pivot + 1, end)
      node
    }
    
    val ans = buildInRange(0, inorder.length - 1)
    ans
  }
  
}