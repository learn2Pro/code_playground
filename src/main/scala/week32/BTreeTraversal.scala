package week32

import week29.TreeNode
import java.util
import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object BTreeTraversal {

  def postorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return Nil
    var curr = root
    val ans = new ArrayBuffer[Int]()
    val stack = new util.Stack[TreeNode]
    while (curr != null || !stack.isEmpty) {
      while (curr != null) {
        ans.append(curr.value)
        stack.push(curr)
        curr = curr.right
      }
      curr = stack.pop()
      curr = curr.left
    }
    ans.toList.reverse
  }

  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return Nil
    var curr = root
    val ans = new ArrayBuffer[Int]()
    val stack = new util.Stack[TreeNode]
    while (curr != null || !stack.isEmpty) {
      while (curr != null) {
        ans.append(curr.value)
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      curr = curr.right
    }
    ans.toList
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return Nil
    var curr = root
    val ans = new ArrayBuffer[Int]()
    val stack = new util.Stack[TreeNode]
    while (curr != null || !stack.isEmpty) {
      while (curr != null) {
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      ans.append(curr._value)
      curr = curr.right
    }
    ans.toList
  }


//  def inorderTraversal(root: TreeNode): List[Int] = {
//    if (root == null) return Nil
//    traversal(root).toList
//  }
//
//  private def traversal(node: TreeNode): ArrayBuffer[Int] = {
//    if (node == null) return ArrayBuffer.empty[Int]
//    val left = traversal(node.left)
//    val right = traversal(node.right)
//    left ++ right ++ ArrayBuffer(node._value)
//  }
}
