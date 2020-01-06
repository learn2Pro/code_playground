package category.tree._400_500

import category.timeline.week29.TreeNode

/**
  * 450. Delete Node in a BST
  */
object _450_DeleteNodeInABST {
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) return root
    val rootroot = new TreeNode(key + 1)
    rootroot.left = root
    val (parent, direction) = find(rootroot, key)
    if (parent == null) return root
    else {
      val insertNode = slideRight(parent, direction)
      adjust(rootroot.left, insertNode)
    }
    rootroot.left
  }
  
  private def slideRight(parent: TreeNode, direction: Boolean) = {
    val tmp = if (direction) parent.left else parent.right
    if (tmp.right == null) {
      assign(parent, tmp.left, direction)
      tmp.right
    } else {
      assign(parent, tmp.right, direction)
      val tmp0 = tmp.right.left
      tmp.right.left = tmp.left
      tmp0
    }
  }
  
  private def assign(node: TreeNode, assignment: TreeNode, direction: Boolean): Unit = {
    if (direction) node.left = assignment else node.right = assignment
  }
  
  private def find(node: TreeNode, key: Int): (TreeNode, Boolean) = {
    if (node == null) (null.asInstanceOf[TreeNode], null.asInstanceOf[Boolean])
    else if (node.left != null && node.left.value == key) (node, true)
    else if (node.right != null && node.right.value == key) (node, false)
    else if (node.value < key) find(node.right, key)
    else find(node.left, key)
  }
  
  private def adjust(parent: TreeNode, node: TreeNode): Unit = {
    if (node == null) return
    adjust(parent, node.left)
    adjust(parent, node.right)
    node.left = null
    node.right = null
    adjust0(parent, node)
  }
  
  private def adjust0(parent: TreeNode, node: TreeNode): Unit = {
    if (node.value > parent.value && parent.right == null) {
      parent.right = node
      return
    }
    if (node.value < parent.value && parent.left == null) {
      parent.left = node
      return
    }
    if (node.value > parent.value) {
      adjust0(parent.right, node)
      return
    }
    if (node.value < parent.value) {
      adjust0(parent.left, node)
      return
    }
  }
}