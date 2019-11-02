package category.timeline.week42

import category.timeline.week29.TreeNode


class BSTIterator(_root: TreeNode) {
  
  import scala.collection.mutable.ArrayBuffer
  
  val iterator: Iterator[Int] = {
    val buffer = new ArrayBuffer[Int]()
    
    def traversal(node: TreeNode): Unit = {
      if (node == null) return
      if (node.left == null && node.right == null) {
        buffer.append(node.value)
        return
      }
      traversal(node.left)
      buffer.append(node.value)
      traversal(node.right)
    }
    
    traversal(_root)
    buffer.iterator
  }
  
  /** @return the next smallest number */
  def next(): Int = {
    iterator.next()
  }
  
  /** @return whether we have a next smallest number */
  def hasNext(): Boolean = {
    iterator.hasNext
  }
  
  
}
