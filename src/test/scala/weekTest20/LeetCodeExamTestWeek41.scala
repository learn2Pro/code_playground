package weekTest20

import org.scalatest.FunSuite
import category.timeline.week41.{IntersectionOfTwoList, ListNode, MaximumGap, VersionComparison}
import category.timeline.week42.{NumberOfOneBit, _}

/**
  * @author tang
  *         6@date 2019/08/03
  */
class LeetCodeExamTestWeek41 extends FunSuite {
  
  test("160. Intersection of Two Linked Lists") {
    val itersection = new IntersectionOfTwoList
    val l0 = new ListNode(4)
    val l1 = new ListNode(1)
    val l2 = new ListNode(8)
    val l3 = new ListNode(4)
    val l4 = new ListNode(5)
    val l5 = new ListNode(5)
    val l6 = new ListNode(0)
    val l7 = new ListNode(1)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l5.next = l6
    l6.next = l7
    l7.next = l2
    val ans = itersection.getIntersectionNode(l0, l5)
    println(ans)
  }
  
  test("164. Maximum Gap") {
    assert(MaximumGap.maximumGap(Array(3, 6, 9, 1)) == 3)
    assert(MaximumGap.maximumGap(Array(1, 3, 100)) == 97)
  }
  
  test("165. Compare Version Numbers") {
    //    assert(VersionComparison.compareVersion("0.1", "1.1") == -1)
    assert(VersionComparison.compareVersion("1.0.1", "1") == 1)
  }
  
  test("166. Fraction to Recurring Decimal") {
    assert(RecurringDecimal.fractionToDecimal(-1, -2147483648) == "0.0000000004656612873077392578125")
    assert(RecurringDecimal.fractionToDecimal(7, -12) == "-0.58(3)")
    assert(RecurringDecimal.fractionToDecimal(-50, 8) == "-6.25")
    assert(RecurringDecimal.fractionToDecimal(2, 1) == "2")
    assert(RecurringDecimal.fractionToDecimal(1, 2) == "0.5")
    assert(RecurringDecimal.fractionToDecimal(1, 3) == "0.(3)")
    assert(RecurringDecimal.fractionToDecimal(2, 3) == "0.(6)")
    assert(RecurringDecimal.fractionToDecimal(1, 6) == "0.1(6)")
    assert(RecurringDecimal.fractionToDecimal(1, 7) == "0.(142857)")
  }
  
  test("229. Majority Element II") {
    //    assert(MajorityElementII.majorityElement(Array(3, 2, 3)) == List(3))
    //    assert(MajorityElementII.majorityElement(Array(1, 2, 3, 4)) == Nil)
    //    assert(MajorityElementII.majorityElement(Array(1, 2)) == List(2, 1))
    //    assert(MajorityElementII.majorityElement(Array(8, 8, 7, 7, 7)) == List(7, 8))
    assert(MajorityElementII.majorityElement(Array(1, 2, 2, 3, 2, 1, 1, 3)) == List(2, 1))
  }
  
  test("171. Excel Sheet Column Number") {
    assert(Excel2Number.titleToNumber("A") == 1)
    assert(Excel2Number.titleToNumber("AB") == 28)
    assert(Excel2Number.titleToNumber("ZY") == 701)
    assert(Excel2Number.titleToNumber("AZ") == 52)
  }
  
  test("172. Factorial Trailing Zeroes") {
    assert(FactorialTrailingZero.trailingZeroes(3) == 0)
    assert(FactorialTrailingZero.trailingZeroes(5) == 1)
    assert(FactorialTrailingZero.trailingZeroes(10) == 2)
  }
  
  test("233. Number of Digit One") {
    assert(DigitOneSize.countDigitOne(0) == 0)
    assert(DigitOneSize.countDigitOne(1) == 1)
    assert(DigitOneSize.countDigitOne(3) == 1)
    assert(DigitOneSize.countDigitOne(125) == 59)
    assert(DigitOneSize.countDigitOne(13) == 6)
    assert(DigitOneSize.countDigitOne(100) == 21)
    assert(DigitOneSize.countDigitOne(101) == 23)
    assert(DigitOneSize.countDigitOne(99) == 20)
    assert(DigitOneSize.countDigitOne(999) == 300)
    assert(DigitOneSize.countDigitOne(9999) == 4000)
  }
  
  test("174. Dungeon Game") {
    assert(DungeonGame.calculateMinimumHP(Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))) == 7)
  }
  
  test("741. Cherry Pickup") {
    //    assert(CherryPickUp.cherryPickup(Array(Array(0, 1, -1), Array(1, 0, -1), Array(1, 1, 1))) == 5)
    //    assert(CherryPickUp.cherryPickup(Array(Array(1, 1, -1), Array(1, -1, 1), Array(-1, 1, 1))) == 0)
    //    assert(CherryPickUp.cherryPickup(Array(
    //      Array(1, 1, 1, 1, 0, 0, 0),
    //      Array(0, 0, 0, 1, 0, 0, 0),
    //      Array(0, 0, 0, 1, 0, 0, 1),
    //      Array(1, 0, 0, 1, 0, 0, 0),
    //      Array(0, 0, 0, 1, 0, 0, 0),
    //      Array(0, 0, 0, 1, 0, 0, 0),
    //      Array(0, 0, 0, 1, 1, 1, 1)
    //    )) == 15)
    
    /**
      * [[1,-1,-1,-1,-1],[1,0,1,-1,-1],[0,-1,1,0,1],[1,0,1,1,0],[-1,-1,-1,1,1]]
      */
    assert(CherryPickUp.cherryPickup(Array(
      Array(1, -1, -1, -1, -1),
      Array(1, 0, 1, -1, -1),
      Array(0, -1, 1, 0, 1),
      Array(1, 0, 1, 1, 0),
      Array(-1, -1, -1, 1, 1)
    )) == 10)
  }
  
  test("179. Largest Number") {
    assert(LargestNumber.largestNumber(Array(10, 2)) == "210")
    assert(LargestNumber.largestNumber(Array(3, 30, 34, 5, 9)) == "9534330")
    assert(LargestNumber.largestNumber(Array(9, 98, 1)) == "9981")
    assert(LargestNumber.largestNumber(Array(121, 12)) == "12121")
  }
  
  test("191. Number of 1 Bits") {
    val task = new NumberOfOneBit
    assert(task.hammingWeight(7) == 3)
    assert(task.hammingWeight(5) == 2)
  }
  
}
