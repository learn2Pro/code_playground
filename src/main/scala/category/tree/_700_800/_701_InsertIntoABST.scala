package category.tree._700_800

import category.timeline.week29.TreeNode

/**
  * 701. Insert into a Binary Search Tree
  */
object _701_InsertIntoABST {
  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    
    def insert(node: TreeNode, v: Int): Unit = {
      if (node.value > v && node.left == null) {
        node.left = new TreeNode(v)
        return
      }
      if (node.value < v && node.right == null) {
        node.right = new TreeNode(v)
        return
      }
      if (node.value > v) insert(node.left, v)
      else insert(node.right, v)
    }
    
    insert(root, `val`)
    root
  }
}