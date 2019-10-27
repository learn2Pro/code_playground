package category.time.week37

import category.time.week29.TreeNode

/**
  * 105. Construct Binary Tree from Preorder and Inorder Traversal
  */
object ReconstructBTreeII {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    var pIndex = postorder.length - 1
    val location = inorder.zipWithIndex.toMap
    
    def buildInRange(start: Int, end: Int): TreeNode = {
      if (start > end) return null
      val node = new TreeNode(postorder(pIndex))
      pIndex -= 1
      val pivot = location(node.value)
      node.right = buildInRange(pivot + 1, end)
      node.left = buildInRange(start, pivot - 1)
      node
    }
    
    val ans = buildInRange(0, inorder.length - 1)
    ans
  }
  
}