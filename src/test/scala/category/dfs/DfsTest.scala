/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.dfs

import category.bsearch._300_400.{_315_Solution, _327_Solution, _352_Solution_JAVA, _378_Solution}
import category.bsearch._400_500.{_406_Solution, _475_Solution, _497_Solution}
import category.bsearch._600_700.{_658_Solution, _668_Solution_JAVA}
import category.bsearch._700_800.{RangeModule, _744_Solution, _786_Solution}
import category.dfs._200_300.{_200_NumberOfIslands, _207_CourseSchedule}
import category.dfs._300_400.{_329_LongestIncreasingPathInAMatrix, _332_ReconstructItinerary}
import category.dfs._400_500._
import category.dfs._500_600._546_Solution
import category.dfs._600_700.{_664_Solution, _679_Solution}
import category.dfs._700_800.{_721_Solution, _743_Solution, _749_Solution, _778_Solution}
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
  
  test("_664_Solution") {
    assert(_664_Solution.strangePrinter("aaabbb") == 2)
  }
  
  test("_546_Solution") {
    assert(_546_Solution.removeBoxes(Array(1, 3, 2, 2, 2, 3, 4, 3, 1)) == 23)
  }
  
  test("_679_Solution") {
    assert(!_679_Solution.judgePoint24(Array(1, 2, 1, 2)))
  }
  
  test("_721_Solution") {
    assert(_721_Solution.accountsMerge(
      List(
        List("David", "David0@m.co", "David4@m.co", "David3@m.co"),
        List("David", "David5@m.co", "David5@m.co", "David0@m.co"),
        List("David", "David1@m.co", "David4@m.co", "David0@m.co"),
        List("David", "David0@m.co", "David1@m.co", "David3@m.co"),
        List("David", "David4@m.co", "David1@m.co", "David3@m.co")
      )) == Nil)
    assert(_721_Solution.accountsMerge(
      List(
        List("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        List("John", "johnsmith@mail.com", "john00@mail.com"),
        List("Mary", "mary@mail.com"),
        List("John", "johnnybravo@mail.com")
      )
    ) == Nil)
  }
  
  test("_743_Solution") {
    assert(_743_Solution.networkDelayTime(
      Array(
        Array(1, 2, 1),
        Array(2, 3, 2),
        Array(1, 3, 4)
      ), 3, 1) == 3)
    assert(_743_Solution.networkDelayTime(
      Array(
        Array(1, 2, 1),
        Array(2, 3, 2),
        Array(1, 3, 2)
      ), 3, 1) == 2)
  }
  test("_749_Solution") {
    /*[[0,1,0,0,0,0,0,1],[0,1,0,1,0,0,0,1],[0,0,0,0,0,0,0,1]]*/
    assert(_749_Solution.containVirus(Array(
      Array(0, 1, 0, 0, 0, 0, 0, 1),
      Array(0, 1, 0, 1, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 0, 0, 0, 1)
    )) == 13)
    assert(_749_Solution.containVirus(Array(
      Array(1, 1, 1, 0, 0, 0, 0, 0, 0),
      Array(1, 0, 1, 0, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 0, 0, 0, 0, 0, 0)
    )) == 13)
    assert(_749_Solution.containVirus(Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1)
    )) == 4)
    assert(_749_Solution.containVirus(Array(
      Array(0, 1, 0, 0, 0, 0, 0, 1),
      Array(0, 1, 0, 0, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 0, 0, 0, 0)
    )) == 10)
  }
  
  test("_778_Solution") {
    assert(_778_Solution.swimInWater(
      Array(
        Array(10, 12, 4, 6),
        Array(9, 11, 3, 5),
        Array(1, 7, 13, 8),
        Array(2, 0, 15, 14)
      )
    ) == 14)
    assert(_778_Solution.swimInWater(
      Array(
        Array(0, 1, 2, 3, 4),
        Array(24, 23, 22, 21, 5),
        Array(12, 13, 14, 15, 16),
        Array(11, 17, 18, 19, 20),
        Array(10, 9, 8, 7, 6)
      )
    ) == 16)
    assert(_778_Solution.swimInWater(
      Array(
        Array(0, 2),
        Array(1, 3)
      )
    ) == 3)
  }
  
  test("_315_Solution") {
    assert(_315_Solution.countSmaller(Array(
      26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7,
      35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28,
      94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65,
      36, 100, 41)) == List(10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9,
      6, 12, 5, 17, 9, 19, 12, 14, 6, 12, 5, 12, 3, 0,
      10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0))
    assert(_315_Solution.countSmaller(Array(5, 2, 6, 1)) == List(2, 1, 1, 0))
    assert(_315_Solution.countSmaller(Array(5, 2, 6, 2)) == List(2, 0, 1, 0))
  }
  
  test("_327_Solution") {
    assert(_327_Solution.countRangeSum(Array(-2, 5, -1), -2, 2) == 3)
  }
  
  test("_406_Solution") {
    assert(_406_Solution.reconstructQueue(
      Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))
    ) == null)
  }
  test("_352_Solution") {
    val instance = new _352_Solution_JAVA()
    instance.addNum(6)
    var i = instance.getIntervals()
    instance.addNum(6)
    i = instance.getIntervals()
    instance.addNum(0)
    i = instance.getIntervals()
    instance.addNum(4)
    i = instance.getIntervals()
    instance.addNum(8)
    i = instance.getIntervals()
    instance.addNum(7)
    i = instance.getIntervals()
    instance.addNum(6)
    i = instance.getIntervals()
    instance.addNum(4)
    i = instance.getIntervals()
    instance.addNum(7)
    i = instance.getIntervals()
    instance.addNum(5)
    i = instance.getIntervals()
    println("end")
  }
  
  test("RangeModule") {
    var i0 = new RangeModule
    //    i0.addRange(10, 20)
    //    i0.removeRange(14, 16)
    //    assert(i0.queryRange(10, 14))
    //    assert(!i0.queryRange(13, 15))
    //    assert(i0.queryRange(16, 17))
    //
    //    /**
    //      * ["RangeModule","addRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange"]
    //      * [[],[6,8],[7,8],[8,9],[8,9],[1,3],[1,8],[2,4],[2,9],[4,6]]
    //      */
    //    i0 = new RangeModule
    //    i0.addRange(6, 8)
    //    i0.removeRange(7, 8)
    //    i0.removeRange(8, 9)
    //    i0.addRange(8, 9)
    //    i0.removeRange(1, 3)
    //    i0.addRange(1, 8)
    //    assert(i0.queryRange(2, 4))
    //    assert(i0.queryRange(2, 9))
    //    assert(i0.queryRange(4, 6))
    
    /**
      * ["RangeModule",
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      * "queryRange","addRange","queryRange","removeRange",
      * [27,78],[31,35],[87,91],[37,84]
      * "removeRange","addRange","addRange","queryRange",
      * [26,57],[65,87],[76,91],[37,77]
      * "queryRange","addRange","addRange","removeRange",
      * [18,66],[22,97],[2,91],[82,98]
      * "removeRange","removeRange","queryRange","removeRange",
      * [41,46],[6,78],[44,80],[90,94]
      * "removeRange","addRange","queryRange","removeRange",
      * [37,88],[75,90],[23,37],[18,80]
      * "addRange","addRange","queryRange","removeRange",
      * [92,93],[3,80],[68,86],[68,92]
      * "queryRange","addRange","addRange","addRange",
      * [52,91],[43,53],[36,37],[60,74]
      * "addRange","addRange","removeRange","removeRange",
      * [4,9],[44,80],[85,93],[56,83]
      * "addRange","queryRange","queryRange","removeRange",
      * [9,26],[59,64],[16,66],[29,36]
      * "removeRange","removeRange","addRange","queryRange",
      * [51,96],[56,80],[13,87],[42,72]
      * "removeRange","queryRange","addRange","removeRange",
      * [6,56],[24,53],[43,71],[36,83]
      * "removeRange","queryRange"]
      * [15,45],[10,48]
      */
    //    i0 = new RangeModule
    //    //"queryRange","queryRange","addRange","addRange"
    //    //* [21,34],[27,87],[44,53],[69,89]
    //    assert(!i0.queryRange(21, 34))
    //    assert(!i0.queryRange(27, 87))
    //    i0.addRange(44, 53)
    //    i0.addRange(69, 89)
    //    //* ,"queryRange","queryRange","queryRange","removeRange"
    //    //* [23,26],[80,84],[11,12],[86,91]
    //    assert(!i0.queryRange(23, 26))
    //    assert(i0.queryRange(80, 84))
    //    assert(!i0.queryRange(11, 12))
    //    i0.removeRange(86, 91)
    //    //* ,"addRange","removeRange","addRange","removeRange"
    //    //* [87,94],[34,52],[1,59],[62,96]
    //    i0.addRange(87, 94)
    //    i0.removeRange(34, 52)
    //    i0.addRange(1, 59)
    //    i0.removeRange(62, 96)
    //    //* ,"removeRange","queryRange","queryRange","queryRange",
    //    //* [34,83],[11,59],[59,79],[1,13]
    //    i0.removeRange(34, 83)
    //    assert(!i0.queryRange(11, 59))
    //    assert(!i0.queryRange(59, 79))
    //    assert(i0.queryRange(1, 13))
    ////    * "queryRange","removeRange","addRange","removeRange",
    ////    * [21,23],[9,61],[17,21],[4,8]
    //    assert(i0.queryRange(21, 23))
    //    i0.removeRange(9, 61)
    //    i0.addRange(17, 21)
    //    i0.removeRange(4, 8)
    //    //* "queryRange","addRange","addRange","removeRange",
    //    //* [19,25],[71,98],[23,94],[58,95]
    //    assert(!i0.queryRange(19, 25))
    //    i0.addRange(71, 98)
    //    i0.addRange(23, 94)
    //    i0.removeRange(58, 95)
    //    //* "queryRange","removeRange","removeRange","removeRange",
    //    //* [12,78],[46,47],[50,70],[84,91]
    //    assert(!i0.queryRange(12, 78))
    //    i0.removeRange(46, 47)
    //    i0.removeRange(50, 70)
    //    i0.removeRange(84, 91)
    //    //* "addRange","removeRange","addRange","queryRange",
    //    //* [51,63],[26,64],[38,87],[41,84]
    //    i0.addRange(51, 63)
    //    i0.removeRange(26, 64)
    //    i0.addRange(38, 87)
    //    assert(i0.queryRange(41, 84))
    //    //"queryRange","queryRange","queryRange","queryRange",
    //    //* [19,21],[18,56],[23,39],[29,95]
    //    assert(i0.queryRange(19, 21))
    //    assert(!i0.queryRange(18, 56))
    //    assert(!i0.queryRange(23, 39))
    //    assert(!i0.queryRange(29, 96))
    //    //"addRange","removeRange","addRange","addRange",
    //    //* [79,100],[76,82],[37,55],[30,97]
    //    i0.addRange(79, 100)
    //    i0.removeRange(76, 82)
    //    i0.addRange(37, 55)
    //    i0.addRange(30, 97)
    //    //"addRange","queryRange","removeRange","addRange",
    //    //* [1,36],[18,96],[45,86],[74,92]
    //    i0.addRange(79, 100)
    //    assert(i0.queryRange(76, 82))
    //    i0.removeRange(37, 55)
    //    i0.addRange(30, 97)
    
    /**
      * ["RangeModule",
      * "addRange","removeRange","queryRange","queryRange",
      * [14,100],[1,8],[77,80],[8,43]
      * "queryRange","removeRange","removeRange","removeRange",
      * [4,13],[3,9],[45,49],[41,90]
      * "addRange","addRange","addRange","removeRange",
      * [58,79],[4,83],[34,39],[84,100]
      * "addRange","queryRange","addRange","addRange",
      * [8,9],[32,56],[35,46],[9,100]
      * "queryRange","queryRange","addRange","removeRange",
      * [85,99],[23,33],[10,31],[15,45]
      * "removeRange","removeRange","queryRange","queryRange",
      * "addRange","addRange","queryRange","addRange",
      * "addRange","removeRange","addRange","addRange",
      * "queryRange","removeRange","queryRange","removeRange",
      * "addRange","addRange","queryRange","removeRange","removeRange","addRange","queryRange","queryRange","removeRange","removeRange","removeRange","queryRange","addRange","removeRange","removeRange","queryRange","removeRange","removeRange","queryRange","addRange","addRange","removeRange","queryRange","queryRange","addRange","removeRange","removeRange","addRange","addRange","addRange","addRange","queryRange","removeRange","addRange","addRange","addRange","queryRange","addRange","removeRange","queryRange","removeRange","removeRange","removeRange","queryRange","queryRange","queryRange","queryRange","queryRange","removeRange","queryRange","removeRange","queryRange","addRange","queryRange"]
      * [[],,,,,,[52,70],[26,42],[30,70],[60,69],[10,94],[2,89],[26,39],[46,93],[30,83],[42,48],[47,74],[39,45],[14,64],[3,97],[16,34],[28,100],[19,37],[27,91],[55,62],[64,65],[2,48],[55,78],[21,89],[31,76],[13,32],[2,84],[21,88],[12,31],[89,97],[56,72],[16,75],[18,90],[46,60],[20,62],[28,77],[5,78],[58,61],[38,70],[24,73],[72,96],[5,24],[43,49],[2,20],[4,69],[18,98],[26,42],[14,18],[46,58],[16,90],[32,47],[19,36],[26,78],[7,58],[42,54],[42,83],[3,83],[54,82],[71,91],[22,37],[38,94],[20,44],[37,89],[15,54],[1,64],[63,65],[55,58],[23,44],[25,87],[38,85],[27,71]]
      */
    //    i0 = new RangeModule
    //    //    "addRange","removeRange","queryRange","queryRange",
    //    //    * [14,100],[1,8],[77,80],[8,43]
    //    i0.addRange(14, 100)
    //    i0.removeRange(1, 8)
    //    assert(i0.queryRange(77, 80))
    //    assert(!i0.queryRange(8, 43))
    //    //    * "queryRange","removeRange","removeRange","removeRange",
    //    //    * [4,13],[3,9],[45,49],[41,90]
    //    assert(!i0.queryRange(4, 13))
    //    i0.removeRange(3, 9)
    //    i0.removeRange(45, 49)
    //    i0.removeRange(41, 90)
    //    //    * "addRange","addRange","addRange","removeRange",
    //    //    * [58,79],[4,83],[34,39],[84,100]
    //    i0.addRange(58, 79)
    //    i0.addRange(4, 83)
    //    i0.addRange(34, 39)
    //    i0.removeRange(84, 100)
    //    //    * "addRange","queryRange","addRange","addRange",
    //    //    * [8,9],[32,56],[35,46],[9,100]
    //    i0.addRange(8, 9)
    //    assert(i0.queryRange(32, 56))
    //    i0.addRange(35, 46)
    //    i0.addRange(9, 100)
    //    //    * "queryRange","queryRange","addRange","removeRange",
    //    //    * [85,99],[23,33],[10,31],[15,45]
    //    assert(i0.queryRange(85, 99))
    //    assert(i0.queryRange(23, 33))
    //    i0.addRange(10, 31)
    //    i0.removeRange(15, 45)
    
    /**
      * ["RangeModule",,,,]
      * [[],,,,,]
      */
    i0 = new RangeModule
    //"queryRange","removeRange","addRange","queryRange"
    //[2,9],[7,9],[1,6],[4,7]
    assert(!i0.queryRange(2, 9))
    i0.removeRange(7, 9)
    i0.addRange(1, 6)
    assert(!i0.queryRange(4, 7))
    //"queryRange","queryRange","removeRange","addRange"
    //[3,10],[1,8],[9,10],[2,5]
    assert(!i0.queryRange(3, 10))
    assert(!i0.queryRange(1, 8))
    i0.removeRange(9, 10)
    i0.addRange(2, 5)
    //"addRange","queryRange","queryRange","queryRange"
    //[6,9],[5,9],[3,4],[9,10]
    i0.addRange(6, 9)
    assert(i0.queryRange(5, 9))
    assert(i0.queryRange(3, 4))
    assert(!i0.queryRange(9, 10))
    //"removeRange","queryRange","addRange","queryRange"
    //[7,9],[2,8],[1,7],[1,2]
    i0.removeRange(7, 9)
    assert(!i0.queryRange(2, 8))
    i0.addRange(1, 7)
    assert(i0.queryRange(1, 2))
    //"removeRange","addRange","removeRange","queryRange"
    //[7,9],[5,10],[8,9],[3,8]
    i0.removeRange(7, 9)
    i0.addRange(5, 9)
    i0.removeRange(8, 9)
    assert(i0.queryRange(3, 8))
    
  }
  
  test("_378_Solution") {
    assert(_378_Solution.kthSmallest(Array(
      Array(1, 5, 9),
      Array(10, 11, 13),
      Array(12, 13, 15)
    ), 8) == 13)
  }
  
  test("_475_Solution") {
    assert(_475_Solution.findRadius(Array(1, 5), Array(10)) == 9)
    assert(_475_Solution.findRadius(Array(1, 2, 3, 4), Array(1, 4)) == 1)
  }
  
  test("_497_Solution") {
    /**
      * [82918473, -57180867, 82918476, -57180863],
      * [83793579, 18088559, 83793580, 18088560],
      * [66574245, 26243152, 66574246, 26243153],
      * [72983930, 11921716, 72983934, 11921720]
      */
    val instance = new _497_Solution(Array(
      Array(82918473, -57180867, 82918476, -57180863),
      Array(83793579, 18088559, 83793580, 18088560),
      Array(66574245, 26243152, 66574246, 26243153),
      Array(72983930, 11921716, 72983934, 11921720)
    ))
    assert(instance.pick()(0) > 82918473)
    assert(instance.pick()(0) > 82918473)
    assert(instance.pick()(0) > 82918473)
    assert(instance.pick()(0) > 82918473)
  }
  
  test("_658_Solution") {
    assert(_658_Solution.findClosestElements(Array(1, 2, 3, 4, 5), 4, 3) == List(1, 2, 3, 4))
    assert(_658_Solution.findClosestElements(Array(0, 1, 1, 1, 2, 3, 6, 7, 8, 9), 9, 4) == List(0, 1, 1, 1, 2, 3, 6, 7, 8))
    assert(_658_Solution.findClosestElements(Array(0, 1, 1, 1, 2, 3, 6, 7, 8, 9), 3, 4) == List(2, 3, 6))
  }
  
  test("_786_Solution") {
    assert(_786_Solution.kthSmallestPrimeFraction(Array(1, 2, 3, 5), 3) sameElements Array(2, 5))
    assert(_786_Solution.kthSmallestPrimeFraction(Array(1, 7), 1) sameElements Array(1, 7))
  }
  
  test("_668_Solution") {
    val instance = new _668_Solution_JAVA
    assert(instance.findKthNumber(42, 34, 401) == 126)
    assert(instance.findKthNumber(3, 3, 5) == 3)
    assert(instance.findKthNumber(2, 3, 6) == 6)
  }
  
  test("_744_Solution") {
    assert(_744_Solution.nextGreatestLetter(Array(
      'c', 'f', 'j'
    ), 'g') == 'j')
  }
}

