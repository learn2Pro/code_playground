package week37

import week29.TreeNode

/**
  * 103. Binary Tree Zigzag Level Order Traversal
  */
object ZigzagLevelOrderTraversal {

  import scala.collection.mutable.ArrayBuffer

  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    val buffer = new ArrayBuffer[List[Int]]()
    print(root, 0, buffer)
    for (i <- buffer.indices if i % 2 == 1) {
      buffer(i) = buffer(i).reverse
    }
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