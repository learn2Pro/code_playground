/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree

import category.tree._200_300._
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version TreeTest.scala, v 0.1 2020年01月04日 15:31 tang Exp $
  */
class TreeTest extends FunSuite {
  
  test("_222_CountCompleteTreeNodes") {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(4)
    val n5 = new TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    assert(_222_CountCompleteTreeNodes.countNodes(n1) == 5)
  }
  
  test("_226_InvertBTree") {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(4)
    val n5 = new TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    val n6 = _226_InvertBTree.invertTree(n1)
    println(n6)
  }
  
  test("_230_KthSmallestElementInABST") {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(4)
    val n5 = new TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    val n6 = _230_KthSmallestElementInABST.kthSmallest(n1, 1)
    println(n6)
  }
  
  test("TraversalOfTree") {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(4)
    val n5 = new TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    assert(TraversalOfTree.inOrder(n1) == List(4, 2, 5, 1, 3))
    assert(TraversalOfTree.postOrder(n1) == List(4, 5, 2, 3, 1))
    assert(TraversalOfTree.preOrder(n1) == List(1, 2, 4, 5, 3))
  }
  
  test("_297_SerAndDeserBTree") {
    val codec = new _297_SerAndDeserBTree
    val n1 = new TreeNode(5)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(2)
    val n5 = new TreeNode(4)
    val n6 = new TreeNode(3)
    val n7 = new TreeNode(1)
    n1.left = n2
    n1.right = n3
    n3.left = n4
    n3.right = n5
    n4.left = n6
    n4.right = n7
    val n8 = new TreeNode(1)
    assert(codec.serialize(n8) == "1")
    assert(codec.serialize(n1) == "5,2,3,null,null,2,4,3,1")
    assert(codec.deserialize("5,2,3,null,null,2,4,3,1") == n1)
    assert(codec.deserialize("1,2,3,4,5,null,null") == n1)
  }
  
}
