package week37

import week29.TreeNode

/**
  * 95. Unique Binary Search Trees II
  */
object UniqueBinarySearchTreesII {
  def generateTrees(n: Int): List[TreeNode] = {
    if (n == 0) return Nil
    if (n == 1) return List(OneAns(1))
    if (n == 2) return TwoAns(1, 2)
    val dp = Array.tabulate[List[TreeNode]](n + 1)(i => Nil)
    dp(0) = List(null)
    dp(1) = List(OneAns(1))
    dp(2) = TwoAns(1, 2)
    for (i <- 3 until n + 1) {
      var ans: List[TreeNode] = Nil
      for (choose <- 0 until i) {
        ans ++= dp(choose).flatMap { left =>
          dp(i - choose - 1).map(traversal(_, choose + 1)).map { right =>
            val curr = OneAns(choose + 1)
            curr.left = left
            curr.right = right
            curr
          }
        }
      }
      dp(i) = ans
    }
    dp(n)
  }

  private def traversal(tree: TreeNode, start: Int): TreeNode = {
    if (tree != null) {
      val copy = new TreeNode(tree._value + start)
      copy.left = tree.left
      copy.right = tree.right
      copy.left = traversal(copy.left, start)
      copy.right = traversal(copy.right, start)
      copy
    } else {
      null
    }
  }

  private def OneAns(x: Int): TreeNode = {
    new TreeNode(x)
  }

  /**
    * x<y
    */
  private def TwoAns(x: Int, y: Int): List[TreeNode] = {
    val n0 = new TreeNode(x)
    val n1 = new TreeNode(y)
    n0.right = n1
    val n2 = new TreeNode(x)
    val n3 = new TreeNode(y)
    n3.left = n2
    List(n0, n3)
  }
}