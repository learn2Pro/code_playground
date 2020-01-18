/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree

import category.timeline.week29.{TreeNode => STNode}
import category.tree._300_400._337_HouseRobberIII
import category.tree._400_500.{_437_PathSumIII, _450_DeleteNodeInABST}
import category.tree._500_600.{_508_MostFreqSubTreeSum, _538_ConvertBST2GreaterTree}
import category.tree._600_700._
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version TreeTest.scala, v 0.1 2020年01月04日 15:31 tang Exp $
  */
class TreeTestV2 extends FunSuite {
  
  test("_337_HouseRobberIII") {
    val n1 = new STNode(4)
    val n2 = new STNode(1)
    val n3 = new STNode(2)
    val n4 = new STNode(3)
    n1.left = n2
    n2.left = n3
    n3.left = n4
    assert(_337_HouseRobberIII.rob(n1) == 7)
  }
  
  test("_437_PathSumIII") {
    val n1 = new STNode(1)
    val n2 = new STNode(-2)
    val n3 = new STNode(-3)
    val n4 = new STNode(1)
    val n5 = new STNode(3)
    val n6 = new STNode(-2)
    val n7 = new STNode(-1)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n4.left = n7
    assert(_437_PathSumIII.pathSum(n1, 1) == 3)
    
  }
  test("_450_DeleteNodeInABST") {
    val n1 = new STNode(5)
    val n2 = new STNode(3)
    val n3 = new STNode(6)
    val n4 = new STNode(2)
    val n5 = new STNode(4)
    val n6 = new STNode(7)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.right = n6
    assert(_450_DeleteNodeInABST.deleteNode(n1, 3) == n1)
    assert(_450_DeleteNodeInABST.deleteNode(n1, 5) == n3)
  }
  
  test("_508_MostFreqSubTreeSum") {
    val n1 = new STNode(5)
    val n2 = new STNode(2)
    val n3 = new STNode(-3)
    n1.left = n2
    n1.right = n3
    assert(_508_MostFreqSubTreeSum.findFrequentTreeSum(n1) sameElements Array(-3, 4, 2))
  }
  
  test("_538_ConvertBST2GreaterTree") {
    val n1 = new STNode(20)
    val n2 = new STNode(10)
    val n3 = new STNode(30)
    val n4 = new STNode(5)
    val n5 = new STNode(11)
    n1.left = n2
    n1.right = n3
    n2.right = n4
    n2.right = n5
    assert(_538_ConvertBST2GreaterTree.convertBST(n1) == n1)
  }
  
  test("_652_FindDupSubtrees") {
    val n1 = new STNode(0)
    val n2 = new STNode(0)
    val n3 = new STNode(0)
    val n4 = new STNode(0)
    val n5 = new STNode(0)
    val n6 = new STNode(0)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n3.right = n5
    n5.right = n6
    assert(_652_FindDupSubtrees.findDuplicateSubtrees(n1) == List(n6))
  }
  
  test("_654_MaximumBTree") {
    assert(_654_MaximumBTree.constructMaximumBinaryTree(Array(3, 2, 1, 6, 0, 5)) == null)
  }
  
  test("_662_MaximumWidthOfBTree") {
    val n1 = new STNode(1)
    val n2 = new STNode(3)
    val n3 = new STNode(2)
    val n4 = new STNode(5)
    val n5 = new STNode(3)
    val n6 = new STNode(9)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n3.right = n5
    n5.right = n6
    assert(_662_MaximumWidthOfBTree.widthOfBinaryTree(n1) == 4)
  }
  
  test("_684_RedundantConnection") {
    assert(_684_RedundantConnection.findRedundantConnection(Array(
      Array(3, 4), Array(1, 2), Array(2, 4), Array(3, 5), Array(2, 5)
    )) sameElements Array(2, 5))
    assert(_684_RedundantConnection.findRedundantConnection(Array(
      Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 4), Array(1, 5)
    )) sameElements Array(1, 4))
    assert(_684_RedundantConnection.findRedundantConnection(Array(
      Array(30, 44), Array(34, 47), Array(22, 32), Array(35, 44), Array(26, 36),
      Array(2, 15), Array(38, 41), Array(28, 35), Array(24, 37), Array(14, 49),
      Array(44, 45), Array(11, 50), Array(20, 39), Array(7, 39), Array(19, 22),
      Array(3, 17), Array(15, 25), Array(1, 39), Array(26, 40), Array(5, 14),
      Array(6, 23), Array(5, 6), Array(31, 48), Array(13, 22), Array(41, 44),
      Array(10, 19), Array(12, 41), Array(1, 12), Array(3, 14), Array(40, 50),
      Array(19, 37), Array(16, 26), Array(7, 25), Array(22, 33), Array(21, 27),
      Array(9, 50), Array(24, 42), Array(43, 46), Array(21, 47), Array(29, 40),
      Array(31, 34), Array(9, 31), Array(14, 31), Array(5, 48), Array(3, 18),
      Array(4, 19), Array(8, 17), Array(38, 46), Array(35, 37), Array(17, 43))
    ) sameElements Array(5, 48))
  }
  
  test("_685_RedundantConnectionII") {
    assert(_685_RedundantConnectionII.findRedundantDirectedConnection(
      Array(Array(2, 1), Array(3, 1), Array(4, 2), Array(1, 4))
    ) sameElements Array(2, 1))
  }
}
