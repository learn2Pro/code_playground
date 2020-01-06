/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree._300_400

import category.timeline.week29.TreeNode

/**
  * 337. House Robber III
  */
object _337_HouseRobberIII {
  def rob(root: TreeNode): Int = {
    def dp(node: TreeNode): (Int, Int) = {
      if (node == null) return (0, 0)
      val (l0, l1) = dp(node.left)
      val (r0, r1) = dp(node.right)
      (node.value + l1 + r1, Math.max(l0, l1) + Math.max(r0, r1))
    }
    
    val (rob, notRob) = dp(root)
    Math.max(rob, notRob)
  }
  
  //  def rob(root: TreeNode): Int = {
  //    if (root == null) return 0
  //    var sum = 0
  //    if (root.left != null) sum += (rob(root.left.left) + rob(root.left.right))
  //    if (root.right != null) sum += (rob(root.right.left) + rob(root.right.right))
  //    Math.max(sum + root.value, rob(root.left) + rob(root.right))
  //  }
}
