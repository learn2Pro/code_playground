package week32

import week29.TreeNode

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object BSTValidate {
  def isValidBST(root: TreeNode): Boolean = {
    if (root == null) return true
    val rootBST =
      (root.left != null && root.right != null && root._value > root.left._value && root._value < root.right.value) ||
        (root.left == null && root.right != null && root._value < root.right.value) ||
        (root.left != null && root.right == null && root._value > root.left._value) ||
        (root.left == null && root.right == null)
    rootBST && valid((root.value, Long.MaxValue), root.right) && valid((Long.MinValue, root.value), root.left)
  }

  private def valid(range: (Long, Long), node: TreeNode): Boolean = {
    if (node == null) return true
    val isBSTNode =
      (node.left != null && node.right != null && node._value > node.left._value && node._value < node.right.value) ||
        (node.left == null && node.right != null && node._value < node.right.value) ||
        (node.left != null && node.right == null && node._value > node.left._value) ||
        (node.left == null && node.right == null)
    val inRange = node.value > range._1 && node.value < range._2
    isBSTNode && inRange && valid((range._1, node.value), node.left) && valid((node.value, range._2), node.right)
  }
}
