/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.bfs

import category.backtrack._306_Solution
import category.design.{MedianFinder, MyLinkedList, WordFilter}
import category.graph._803_Solution
import category.sort._220_Solution
import category.stack.{_331_Solution, _456_Solution}
import category.twopointer.{_424_Solution, _524_Solution, _567_Solution}
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
  
  test("_424_Solution") {
    assert(_424_Solution.characterReplacement("ABAB", 2) == 4)
  }
  
  test("_524_Solution") {
    assert(_524_Solution.findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi", List("jpthiudqzzeugzwwsngebdeai", "nbmxgkduynigvzuyblwjepn")) == "nbmxgkduynigvzuyblwjepn")
    assert(_524_Solution.findLongestWord("abpcplea", List("ale", "apple", "monkey", "plea")) == "apple")
  }
  
  test("_567_Solution") {
    assert(_567_Solution.checkInclusion("adc", "dcda"))
  }
  
  test("_331_Solution") {
    assert(_331_Solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
  }
  
  test("_456_Solution") {
    assert(_456_Solution.find132pattern(Array(-1, 3, 2, 0)))
  }
  
  test("_803_Solution") {
    assert(_803_Solution.hitBricks(
      Array(Array(1, 0, 1), Array(1, 1, 1)),
      Array(Array(0, 0), Array(0, 2), Array(1, 1))) sameElements Array(0, 3, 0))
    assert(_803_Solution.hitBricks(
      Array(Array(1, 0, 0, 0), Array(1, 1, 1, 0)),
      Array(Array(1, 0))) sameElements Array(2))
  }
  
  test("_306_Solution") {
    assert(!_306_Solution.isAdditiveNumber("199001200"))
    assert(_306_Solution.isAdditiveNumber("123"))
    assert(!_306_Solution.isAdditiveNumber("9999110000100001"))
    assert(_306_Solution.isAdditiveNumber("999911000010001"))
    assert(_306_Solution.isAdditiveNumber("199100199"))
    assert(_306_Solution.isAdditiveNumber("112358"))
  }
  
  /**
    * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    * [[],[1],[2],[],[3],[],[4],[],[5],[],[6],[],[7],[],[8],[]]
    * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    * [[],[1],[],[2],[],[3],[],[4],[],[5],[],[6],[],[7],[],[8],[]]
    * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
    *
    * [[],[12],[],[10],[],[13],[],[11],[],[5],[],[15],[],[1],[],[11],[],[6],[],[17],[],
  * [14],[],[8],[],[17],[],[6],[],[4],[],[16],[],[8],[],[10],[],[2],[],[12],[],[0],[]]
    */
  test("MedianFinder") {
    var instance = new MedianFinder
    instance.addNum(12)
    assert(instance.findMedian() == 12)
    instance.addNum(10)
    assert(instance.findMedian() == 11)
    instance.addNum(13)
    assert(instance.findMedian() == 12)
    instance.addNum(11)
    assert(instance.findMedian() == 11.5)
    instance.addNum(5)
    assert(instance.findMedian() == 11)
    instance.addNum(15)
    assert(instance.findMedian() == 11.5)
    instance.addNum(1)
    assert(instance.findMedian() == 11)
    instance.addNum(11)
    assert(instance.findMedian() == 11)
    instance.addNum(6)
    assert(instance.findMedian() == 11)
    instance.addNum(17)
    assert(instance.findMedian() == 11)
    instance.addNum(14)
    assert(instance.findMedian() == 11)
    instance.addNum(8)
    assert(instance.findMedian() == 11)
    instance.addNum(17)
    assert(instance.findMedian() == 11)
    instance.addNum(6)
    assert(instance.findMedian() == 11)
    instance.addNum(4)
    assert(instance.findMedian() == 11)
    instance.addNum(16)
    assert(instance.findMedian() == 11)
    instance.addNum(8)
    assert(instance.findMedian() == 11)
    instance.addNum(10)
    assert(instance.findMedian() == 10.5)
    instance.addNum(2)
    assert(instance.findMedian() == 10)
    instance.addNum(12)
    assert(instance.findMedian() == 10.5)
    instance.addNum(0)
    assert(instance.findMedian() == 10)
    
    instance = new MedianFinder
    instance.addNum(1)
    instance.addNum(2)
    assert(instance.findMedian() == 1.5)
    instance.addNum(3)
    assert(instance.findMedian() == 2)
    instance.addNum(4)
    assert(instance.findMedian() == 2.5)
    instance.addNum(5)
    assert(instance.findMedian() == 3)
    instance.addNum(6)
    assert(instance.findMedian() == 3.5)
    instance.addNum(7)
    assert(instance.findMedian() == 4)
    instance.addNum(8)
    assert(instance.findMedian() == 4.5)
    instance = new MedianFinder
    instance.addNum(6)
    assert(instance.findMedian() == 6)
    instance.addNum(10)
    assert(instance.findMedian() == 8)
    instance.addNum(2)
    assert(instance.findMedian() == 6)
    instance.addNum(6)
    assert(instance.findMedian() == 6)
    instance.addNum(5)
    assert(instance.findMedian() == 6)
    instance.addNum(0)
    assert(instance.findMedian() == 5.5)
    instance.addNum(6)
    assert(instance.findMedian() == 6)
    instance.addNum(3)
    assert(instance.findMedian() == 5.5)
    instance.addNum(1)
    assert(instance.findMedian() == 5)
    instance.addNum(0)
    assert(instance.findMedian() == 4)
    instance.addNum(0)
    assert(instance.findMedian() == 3)
  }
  
  /**
    *
    *
    *
    *
    *
    *
    *
    * ,"addAtIndex","deleteAtIndex","addAtTail","addAtHead"
    * [20,90],[30],[40],[56]
    * ,"addAtIndex","addAtHead","addAtHead","get"
    * [15,23],[51],[21],[26]
    * ,"addAtHead","get","addAtHead","deleteAtIndex"
    * [83],[30],[12],[8]
    * ,"get","addAtHead","addAtTail","get",
    * [4],[20],[45],[10]
    * "addAtHead","get","addAtTail","get"
    * [56],[18],[33],[2]
    * ,"addAtTail","addAtHead","addAtIndex","addAtIndex"
    * [70],[57],[31,24],[16,92]
    * ,"addAtHead","addAtHead","deleteAtIndex","get"
    * [40],[23],[26],[1]
    * ,"addAtHead","addAtIndex","addAtTail","get"
    * [92],[3,78],[42],[18]
    * ,"addAtIndex","get","addAtIndex","get"
    * [39,9],[13],[33,17],[51]
    * ,"addAtIndex","addAtIndex","addAtHead","addAtHead"
    * [18,95],[18,33],[80],[21]
    * ,"addAtTail","addAtIndex","get","addAtHead"
    * [7],[17,46],[33],[60]
    * ,"addAtTail","addAtTail","addAtHead","get"
    * [26],[4],[9],[45]
    * ,"addAtTail","addAtHead","addAtTail","get"
    * [38],[95],[78],[54]
    * ,"addAtIndex"]
    * [42,86]
    * [,,,,,,,,,,,,,,,,,,,,,,,,,]
    */
  test("linked list") {
    val instance = new MyLinkedList
    //            ["addAtHead","addAtTail","addAtTail","get",
    //                    * [84],[2],[39],[3]
    instance.addAtHead(84)
    instance.addAtTail(2)
    instance.addAtTail(39)
    instance.get(3)
    //    "get","addAtTail","addAtIndex","addAtHead"
    //    * [1],[42],[1,80],[14]
    instance.get(1)
    instance.addAtTail(42)
    instance.addAtIndex(1, 80)
    instance.addAtHead(14)
    //    ,"addAtHead","addAtTail","addAtTail","addAtTail"
    //    * [1],[53],[98],[19]
    instance.addAtHead(1)
    instance.addAtTail(53)
    instance.addAtTail(98)
    instance.addAtTail(19)
    //    ,"addAtTail","get","addAtHead","addAtHead"
    //    * [12],[2],[16],[33]
    instance.addAtTail(12)
    instance.get(2)
    instance.addAtHead(16)
    instance.addAtHead(33)
    //    ,"addAtIndex","addAtIndex","addAtHead","addAtTail"
    //    * [4,17],[6,8],[37],[43]
    instance.addAtIndex(4, 17)
    instance.addAtIndex(6, 8)
    instance.addAtHead(37)
    instance.addAtTail(43)
    //    ,"deleteAtIndex","addAtHead","addAtHead","addAtIndex"
    //    * [11],[80],[31],[13,23]
    instance.deleteAtIndex(11)
    instance.addAtHead(80)
    instance.addAtHead(31)
    instance.addAtIndex(13, 23)
    //    ,"addAtTail","get","addAtIndex","addAtTail"
    //    * [17],[4],[10,0],[21]
    //    * ,"addAtHead","addAtHead","addAtIndex","addAtTail"
    //    * [73],[22],[24,37],[14]
    //    * ,"addAtHead","addAtHead","get","deleteAtIndex"
    //    * [97],[8],[6],[17]
    instance.addAtTail(17)
    instance.get(4)
    instance.addAtIndex(10, 0)
    instance.addAtTail(21)
    instance.addAtHead(73)
    instance.addAtHead(22)
    instance.addAtIndex(24, 37)
    instance.addAtTail(14)
    instance.addAtHead(97)
    instance.addAtHead(8)
    instance.get(6)
    instance.deleteAtIndex(17)
    //    ,"addAtTail","addAtTail","addAtHead","addAtTail"
    //    * [50],[28],[76],[79]
    //    * ,"get","deleteAtIndex","addAtTail","addAtHead"
    //    * [18],[30],[5],[9]
    //    * ,"addAtTail","deleteAtIndex","addAtTail","deleteAtIndex"
    //    * [83],[3],[40],[26]
    instance.addAtTail(50)
    instance.addAtTail(28)
    instance.addAtHead(76)
    instance.addAtTail(79)
    instance.get(18)
    instance.deleteAtIndex(30)
    instance.addAtTail(5)
    instance.addAtHead(9)
    instance.addAtTail(83)
    instance.deleteAtIndex(3)
    instance.addAtTail(40)
    instance.deleteAtIndex(26)
  }
  
  test("WordFilter") {
    var instance = new WordFilter(Array("apple"))
    //    assert(instance.f("a", "e") == 0)
    instance = new WordFilter(Array(
      "abbbababbb", "baaabbabbb", "abababbaaa", "abbbbbbbba", "bbbaabbbaa", "ababbaabaa", "baaaaabbbb", "babbabbabb", "ababaababb", "bbabbababa"
    ))
    assert(instance.f("", "abaa") == 5)
    assert(instance.f("babbab", "") == 7)
  }
  
  test("_220_Solution") {
    assert(!_220_Solution.containsNearbyAlmostDuplicate(Array(1, 5, 9, 1, 5, 9), 2, 3))
    assert(_220_Solution.containsNearbyAlmostDuplicate(Array(1, 2, 3, 1), 3, 0))
  }
  
}
