/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.bfs

import category.backtrack._306_Solution
import category.design.MedianFinder
import category.graph._803_Solution
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
  
}
