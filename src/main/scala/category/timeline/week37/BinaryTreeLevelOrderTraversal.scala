package category.timeline.week37

import category.timeline.week29.TreeNode


/**
  * 102. Binary Tree Level Order Traversal
  */
object BinaryTreeLevelOrderTraversal {

  import scala.collection.mutable.ArrayBuffer

  def levelOrder(root: TreeNode): List[List[Int]] = {
    val buffer = new ArrayBuffer[List[Int]]()
    print(root, 0, buffer)
    buffer.toList
  }

  private def print(node: TreeNode, level: Int, buffer: ArrayBuffer[List[Int]]): Unit = {
    if (node == null) return
    while (buffer.length <= level) buffer.append(Nil)
    buffer(level) = buffer(level) ++ List(node.value)
    print(node.left, level + 1, buffer)
    print(node.right, level + 1, buffer)
  }
}