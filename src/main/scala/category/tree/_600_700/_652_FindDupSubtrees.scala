package category.tree._600_700

import category.timeline.week29.TreeNode

/**
  * 652. Find Duplicate Subtrees
  */
object _652_FindDupSubtrees {
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
    var ans: List[TreeNode] = Nil
    val alreadyAdd = new java.util.HashSet[String]()
    val inOrders = new java.util.HashSet[String]()
    
    def preOrder(node: TreeNode): String = {
      if (node == null) return "N"
      val current = node.value + preOrder(node.left) + preOrder(node.right)
      if (inOrders.contains(current) && !alreadyAdd.contains(current)) {
        ans ::= node
        alreadyAdd.add(current)
      } else inOrders.add(current)
      current
    }
    
    preOrder(root)
    ans
  }
}