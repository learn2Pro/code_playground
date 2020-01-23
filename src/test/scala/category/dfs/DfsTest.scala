/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.dfs

import category.dfs._200_300.{_200_NumberOfIslands, _207_CourseSchedule}
import category.dfs._300_400.{_329_LongestIncreasingPathInAMatrix, _332_ReconstructItinerary}
import category.dfs._400_500._
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version DfsTest.scala, v 0.1 2020年01月18日 15:45 tang Exp $
  */
class DfsTest extends FunSuite {
  
  test("_200_NumberOfIslands") {
    assert(_200_NumberOfIslands.numIslands(
      Array(
        Array('1', '1', '1', '1', '0'),
        Array('1', '1', '0', '1', '0'),
        Array('1', '1', '0', '0', '0'),
        Array('0', '0', '0', '0', '0')
      )
    ) == 1)
  }
  
  test("_207_CourseSchedule") {
    assert(_207_CourseSchedule.canFinish(2, Array(Array(0, 1))))
  }
  
  test("_329_LongestIncreasingPathInAMatrix") {
    assert(_329_LongestIncreasingPathInAMatrix.longestIncreasingPath(
      Array(
        Array(3, 4, 5),
        Array(3, 2, 6),
        Array(2, 1, 1)
      )
    ) == 5)
  }
  
  test("_332_ReconstructItinerary") {
    assert(_332_ReconstructItinerary.findItinerary(List(List("JFK", "KUL"), List("JFK", "NRT"), List("NRT", "JFK"))) ==
            List("JFK", "NRT", "JFK", "KUL"))
    assert(_332_ReconstructItinerary.findItinerary(
      List(List("JFK", "SFO"), List("JFK", "ATL"), List("SFO", "ATL"), List("ATL", "JFK"), List("ATL", "SFO"))
    ) == List("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"))
    assert(_332_ReconstructItinerary.findItinerary(List(
      List("MUC", "LHR"), List("JFK", "MUC"), List("SFO", "SJC"), List("LHR", "SFO"))
    ) == List("JFK", "MUC", "LHR", "SFO", "SJC"))
    
  }
  
  test("_417_PacificAtlanticWaterFlow") {
    assert(_417_PacificAtlanticWaterFlow.pacificAtlantic(
      Array(
        Array(10, 10, 10),
        Array(10, 1, 10),
        Array(10, 10, 10)
      )
    ) == List(List(1, 2)))
    assert(_417_PacificAtlanticWaterFlow.pacificAtlantic(
      Array(
        Array(1, 2, 2, 3, 5),
        Array(3, 2, 3, 4, 4),
        Array(2, 4, 5, 3, 1),
        Array(6, 7, 1, 4, 5),
        Array(5, 1, 1, 2, 4)
      )
    ) == List(List(1, 2)))
  }
  
  test("_472_Solution") {
    assert(_472_Solution.findAllConcatenatedWordsInADict(Array("")) == Nil)
    assert(_472_Solution.findAllConcatenatedWordsInADict(
      Array("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat")
    ) == List("catsdogcats", "dogcatsdog", "ratcatdogcat"))
  }
  
  test("_473_Solution") {
    assert(_473_Solution.makesquare(Array(1, 1, 2, 2, 2)))
  }
  
  test("_488_Solution") {
    assert(_488_Solution.findMinStep("G", "GGGGG") == 2)
    assert(_488_Solution.findMinStep("WWRRBBWW", "RBRW") == 2)
    assert(_488_Solution.findMinStep("WWRRBBWW", "WRBRW") == 2)
  }
  
  test("_491_Solution_JAVA") {
    assert(new _491_Solution_JAVA().findSubsequences(Array(4, 6, 7, 7)) == null)
  }
  
  test("_529_Solution") {
    assert(_529_Solution.updateBoard(
      Array(
        Array('E', 'E', 'E', 'E', 'E'),
        Array('E', 'E', 'M', 'E', 'E'),
        Array('E', 'E', 'E', 'E', 'E'),
        Array('E', 'E', 'E', 'E', 'E'),
        Array('E', 'E', 'E', 'E', 'E')
      ), Array(3, 0)
    ) == null)
    assert(_529_Solution.updateBoard(
      Array(
        Array('B', '1', 'E', '1', 'B'),
        Array('B', '1', 'M', '1', 'B'),
        Array('B', '1', '1', '1', 'B'),
        Array('B', 'B', 'B', 'B', 'B')
      ), Array(1, 2)
    ) == null)
    
  }
}

