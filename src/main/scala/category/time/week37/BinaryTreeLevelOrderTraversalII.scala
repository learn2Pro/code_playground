package category.time.week37

import category.time.week29.TreeNode


/**
  * 107. Binary Tree Level Order Traversal II
  */
object BinaryTreeLevelOrderTraversalII {
  
  import scala.collection.mutable.ArrayBuffer
  
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    val buffer = new ArrayBuffer[List[Int]]()
    print(root, 0, buffer)
    buffer.reverse.toList
  }
  
  private def print(node: TreeNode, level: Int, buffer: ArrayBuffer[List[Int]]): Unit = {
    if (node == null) return
    while (buffer.length <= level) buffer.append(Nil)
    buffer(level) = buffer(level) ++ List(node.value)
    print(node.left, level + 1, buffer)
    print(node.right, level + 1, buffer)
  }
}