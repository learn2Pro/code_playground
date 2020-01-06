
package category.tree._500_600

import category.timeline.week29.TreeNode

/**
  * 538. Convert BST to Greater Tree
  */
object _538_ConvertBST2GreaterTree {
  /* Get the node with the smallest value greater than this one. *//* Get the node with the smallest value greater than this one. */
  private def getSuccessor(node: TreeNode) = {
    var succ = node.right
    while (succ.left != null && succ.left != node) succ = succ.left
    succ
  }
  
  def convertBST(root: TreeNode): TreeNode = {
    var sum = 0
    var node = root
    while (node != null) {
      /*
      * If there is no right subtree, then we can visit this node and
      * continue traversing left.
      */
      if (node.right == null) {
        sum += node.value
        node.value = sum
        node = node.left
      } else {
        /*
          * If there is a right subtree, then there is at least one node that
          * has a greater value than the current one. therefore, we must
          * traverse that subtree first.
          */
        val succ = getSuccessor(node)
        /*
         * If the left subtree is null, then we have never been here before.
         */
        if (succ.left == null) {
          succ.left = node
          node = node.right
        } else {
          /*
          * If there is a left subtree, it is a link that we created on a
          * previous pass, so we should unlink it and visit this node.
          */
          succ.left = null
          sum += node.value
          node.value = sum
          node = node.left
        }
      }
    }
    root
  }
  
  //  def convertBST(root: TreeNode): TreeNode = {
  //    var sum = 0
  //
  //    def traversal(node: TreeNode) = {
  //      if (node == null) {
  //        traversal(node.right)
  //        sum += node.value
  //        node.value = sum
  //        traversal(node.left)
  //      }
  //      node
  //    }
  //
  //    traversal(root)
  //
  //  }
}