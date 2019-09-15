package week37

import week29.TreeNode

/**
  * 99. Recover Binary Search Tree
  */
object RecoverBinarySearchTree {
  def recoverTree(root: TreeNode): Unit = {
    val rules: Array[Rule] = Array(
      new LeftAndRightSwap, new LeftParentSwap,
      new RightParentSwap, new BSTNotMatch
    )
    var times = 0
    val limit = 3
    while (times < limit) {
      transformDown(root, (node: TreeNode) => {
        rules.foreach { rule =>
          if (rule.restrict(node)) rule.adjust(node)
        }
        node
      })
      times += 1
    }
    root
  }

  trait Rule {
    def restrict(node: TreeNode): Boolean

    def adjust(node: TreeNode): TreeNode
  }

  /**
    * when left > parent && right < parent
    */
  class LeftAndRightSwap extends Rule {
    override def restrict(node: TreeNode): Boolean = {
      node != null &&
              node.left != null &&
              node.right != null &&
              node.left.value > node.value &&
              node.right.value < node.value
    }

    override def adjust(node: TreeNode): TreeNode = {
      val tmp = node.left.value
      node.left.value = node.right.value
      node.left._value = node.right.value
      node.right.value = tmp
      node.right._value = tmp
      node
    }
  }

  /**
    * when left > parent && right > parent && left < right
    * when left > parent && right==null
    */
  class LeftParentSwap extends Rule {
    override def restrict(node: TreeNode): Boolean = {
      node != null && node.left != null && node.left.value > node.value
    }

    override def adjust(node: TreeNode): TreeNode = {
      val tmp = node.value
      node.value = node.left.value
      node._value = node.left.value
      node.left.value = tmp
      node.left._value = tmp
      node
    }
  }

  class RightParentSwap extends Rule {
    override def restrict(node: TreeNode): Boolean = {
      node != null && node.right != null && node.right.value < node.value
    }

    override def adjust(node: TreeNode): TreeNode = {
      val tmp = node.value
      node.value = node.right.value
      node._value = node.right.value
      node.right.value = tmp
      node.right._value = tmp
      node
    }
  }

  class BSTNotMatch extends Rule {
    override def restrict(node: TreeNode): Boolean = {
      if (node == null) return false
      !lessThan(node.left, node.value) || !greaterThan(node.right, node.value)
    }


    override def adjust(node: TreeNode): TreeNode = {
      val abnormal = findFirst(node)
      val tmp = node.value
      node.value = abnormal.value
      node._value = abnormal.value
      abnormal.value = tmp
      abnormal._value = tmp
      node
    }

    private def findFirst(node: TreeNode): TreeNode = {
      if (node == null) return null
      val less = findLessFirst(node.left, node.value)
      if (less != null) return less
      val greater = findGreaterFirst(node.right, node.value)
      greater
    }

    private def findLessFirst(node: TreeNode, num: Int): TreeNode = {
      if (node == null) return null
      if (node.value > num) return node
      val left = findLessFirst(node.left, num)
      if (left != null) return left
      val right = findLessFirst(node.right, num)
      right
    }

    private def findGreaterFirst(node: TreeNode, num: Int): TreeNode = {
      if (node == null) return null
      if (node.value < num) return node
      val left = findGreaterFirst(node.left, num)
      if (left != null) return left
      val right = findGreaterFirst(node.right, num)
      right
    }

    private def lessThan(node: TreeNode, num: Int): Boolean = {
      if (node == null) return true
      if (node.value > num) return false
      lessThan(node.left, num) && lessThan(node.right, num)
    }

    private def greaterThan(node: TreeNode, num: Int): Boolean = {
      if (node == null) return true
      if (node.value < num) return false
      greaterThan(node.left, num) && greaterThan(node.right, num)
    }

  }

  /**
    * pre-order
    */
  private def transformDown(node: TreeNode, f: TreeNode => TreeNode): TreeNode = {
    if (node == null) return node
    val updated = f.apply(node)
    transformDown(updated.left, f)
    transformDown(updated.right, f)
    updated
  }


}