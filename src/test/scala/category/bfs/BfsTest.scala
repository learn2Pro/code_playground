/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.bfs

import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version BfsTest.scala, v 0.1 2020年01月29日 09:53 tang Exp $
  */
class BfsTest extends FunSuite {
  
  test("_310_Solution") {
    assert(_310_Solution.findMinHeightTrees(4, Array(
      Array(1, 0), Array(1, 2), Array(1, 3)
    )) == List(1))
  }
  
  test("_407_Solution") {
    assert(_407_Solution.trapRainWater(Array(
      Array(9, 9, 9, 9, 9, 9, 8, 9, 9, 9, 9),
      Array(9, 0, 0, 0, 0, 0, 1, 0, 0, 0, 9),
      Array(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9),
      Array(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9),
      Array(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9)
    )) == 215)
    assert(_407_Solution.trapRainWater(Array(
      Array(1, 4, 3, 1, 3, 2), Array(3, 2, 1, 3, 2, 4), Array(2, 3, 3, 2, 3, 1)
    )) == 4)
  }
  
  test("_773_Solution") {
    assert(_773_Solution.slidingPuzzle(
      Array(Array(1, 2, 3), Array(4, 0, 5))
    ) == 1)
  }
  
}
