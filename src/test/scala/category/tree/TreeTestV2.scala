/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.tree

import category.timeline.week29.{TreeNode => STNode}
import category.tree._300_400._337_HouseRobberIII
import category.tree._400_500.{_437_PathSumIII, _450_DeleteNodeInABST}
import category.tree._500_600.{_508_MostFreqSubTreeSum, _538_ConvertBST2GreaterTree}
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
}
