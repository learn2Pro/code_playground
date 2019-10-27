package category.time.week38

import category.time.week29.TreeNode


/**
  * 129. Sum Root to Leaf Numbers
  */
object SumRoot2Leaf {
  
  import scala.collection.mutable.ArrayBuffer
  
  def sumNumbers(root: TreeNode): Int = {
    if (root == null) return 0
    val buffer = new ArrayBuffer[List[String]]()
    iterate(root, Nil, buffer)
    buffer.flatten.map(_.toInt).sum
  }
  
  def iterate(node: TreeNode, mid: List[String], buffer: ArrayBuffer[List[String]]): Unit = {
    if (node == null) {
      return
    }
    if (node.left == null && node.right == null) {
      buffer.append(if (mid == Nil) List(node.value.toString) else mid.map(_ + node.value))
      return
    }
    val updated = if (mid == Nil) List(node.value.toString) else mid.map(_ + node.value)
    iterate(node.left, updated, buffer)
    iterate(node.right, updated, buffer)
  }
}