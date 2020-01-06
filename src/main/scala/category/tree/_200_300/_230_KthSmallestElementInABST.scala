package category.tree._200_300

import category.tree.TreeNode

/**
  * 230. Kth Smallest Element in a BST
  */
object _230_KthSmallestElementInABST {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    val stack = new java.util.Stack[TreeNode]()
    var tmp = root
    var size = k
    while (true) {
      while (tmp != null) tmp = stack.push(tmp).left
      tmp = stack.pop()
      size -= 1
      if (size == 0) return tmp.`val`
      tmp = tmp.right
    }
    throw new RuntimeException("could not be here!")
  }
}