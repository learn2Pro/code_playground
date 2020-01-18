/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree._700_800

import category.timeline.week29.TreeNode

/**
  * 700. Search in a Binary Search Tree
  */
object _700_SearchInABST {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return null
    if (root.value == `val`) return root
    if (root.value > `val`) searchBST(root.left, `val`)
    else searchBST(root.right, `val`)
  }
}
