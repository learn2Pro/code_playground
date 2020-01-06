/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree._200_300

import category.tree.TreeNode

/**
  *
  * @author derong.tdr
  * @version TraversalOfTree.scala, v 0.1 2020年01月04日 19:58 tang Exp $
  */
object TraversalOfTree {
  
  def inOrder(root: TreeNode): List[Int] = {
    val stack = new java.util.Stack[TreeNode]
    var ans: List[Int] = Nil
    var tmp = root
    while (true) {
      while (tmp != null) {
        stack.push(tmp)
        tmp = tmp.left
      }
      if (stack.empty()) return ans
      tmp = stack.pop()
      ans = ans ++ List(tmp.`val`)
      tmp = tmp.right
    }
    ans
  }
  
  def preOrder(root: TreeNode): List[Int] = {
    val stack = new java.util.Stack[TreeNode]
    var ans: List[Int] = Nil
    stack.push(root)
    while (!stack.empty()) {
      val top = stack.pop()
      ans = ans ++ List(top.`val`)
      if (top.right != null) stack.push(top.right)
      if (top.left != null) stack.push(top.left)
    }
    ans
  }
  
  def postOrder(root: TreeNode): List[Int] = {
    import scala.collection.JavaConversions._
    val stack = new java.util.Stack[TreeNode]
    stack.push(root)
    var earlyStop = false
    while (!earlyStop) {
      val top = stack.peek()
      if (top.left == null && top.right == null) earlyStop = true
      if (top.right != null) stack.push(top.right)
      if (top.left != null) stack.push(top.left)
    }
    stack.map(_.`val`).toList.reverse
  }
  
}
