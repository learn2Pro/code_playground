package weekTest20

import com.google.common.collect.Lists
import org.scalatest.FunSuite
import week27.ListNode
import week39.{CloneGraph, GasStation, Node, SingleNumberII}
import week40._

/**
  * @author tang
  *         6@date 2019/08/03
  */
class LeetCodeExamTestWeek39 extends FunSuite {
  
  test("133. Clone Graph") {
    val cloneGraph = new CloneGraph
    val n1 = new Node(1)
    val n2 = new Node(2)
    val n3 = new Node(3)
    val n4 = new Node(4)
    val n5 = new Node(5)
    val n6 = new Node(6)
    n1.neighbors = Lists.newArrayList(n2, n4, n6)
    n2.neighbors = Lists.newArrayList(n1, n3)
    n3.neighbors = Lists.newArrayList(n2, n4)
    n4.neighbors = Lists.newArrayList(n1, n3, n5)
    n5.neighbors = Lists.newArrayList(n4)
    n6.neighbors = Lists.newArrayList(n1)
    val ans = cloneGraph.cloneGraph(n1)
    println("end")
  }
  
  test("134. Gas Station") {
    assert(GasStation.canCompleteCircuit(Array(1, 2, 3, 4, 5), Array(3, 4, 5, 1, 2)) == 3)
  }
  
  test("137. Single Number II") {
    //    assert(SingleNumberII.singleNumber(Array(2, 2, 3, 2)) == 3)
    assert(SingleNumberII.singleNumber(Array(0, 1, 0, 1, 0, 1, 99)) == 99)
  }
  
  test("135. Candy") {
    assert(Candy.candy(Array(1, 0, 2)) == 5)
    assert(Candy.candy(Array(1, 2, 2)) == 4)
    assert(Candy.candy(Array(1, 2, 87, 87, 87, 2, 1)) == 13)
  }
  
  test("139. Word Break") {
    assert(WordBreak.wordBreak("leetcode", List("leet", "code")))
    assert(WordBreak.wordBreak("applepenapple", List("apple", "pen")))
    assert(!WordBreak.wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")))
    assert(WordBreak.wordBreak("abcd", List("a", "abc", "b", "cd")))
  }
  
  test("140. Word Break II") {
    //    assert(WordBreakII.wordBreak("catsanddog", List("cat", "cats", "and", "sand", "dog")) == List("cats and dog", "cat sand dog"))
    assert(WordBreakII.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
      , List("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")) == Nil)
    //        val v1 = new WordBreakIIV1
    //        val ans = v1.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //          , Lists.newArrayList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))
    //        println("end")
    
  }
  
  test("143. Reorder List") {
    val l0 = new ListNode(1)
    val l1 = new ListNode(2)
    val l2 = new ListNode(3)
    val l3 = new ListNode(4)
    val l4 = new ListNode(5)
    //    l0.next = l1
    //    l1.next = l2
    //    l2.next = l3
    //    l3.next = l4
    ReorderList.reorderList(l0)
    println("end")
  }
  
  test("146. LRU Cache") {
    val lru = new LRUCache(2)
    lru.put(2, 1)
    lru.put(1, 1)
    lru.put(2, 3)
    lru.put(4, 1)
    println(lru.get(1))
    println(lru.get(2))
  }
  
  test("149. Max Points on a Line") {
    assert(MaxPointsOnLine.maxPoints(Array(Array(1, 1), Array(2, 2), Array(3, 3))) == 3)
    assert(MaxPointsOnLine.maxPoints(Array(
      Array(1, 1), Array(3, 2), Array(5, 3),
      Array(4, 1), Array(2, 3), Array(1, 4))
    ) == 4)
    assert(MaxPointsOnLine.maxPoints(Array(Array(0, 0))) == 1)
    assert(MaxPointsOnLine.maxPoints(Array(Array(0, 0), Array(1, 65536), Array(65536, 0))) == 2)
    assert(MaxPointsOnLine.maxPoints(Array(
      Array(84, 250), Array(0, 0), Array(1, 0), Array(0, -70), Array(0, -70),
      Array(1, -1), Array(21, 10), Array(42, 90), Array(-42, -230))) == 6)
  }
  
  test("150. Evaluate Reverse Polish Notation") {
    assert(RPNEvaluator.evalRPN(Array("2", "1", "+", "3", "*")) == 9)
    assert(RPNEvaluator.evalRPN(Array("4", "13", "5", "/", "+")) == 6)
    assert(RPNEvaluator.evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)
  }
  
  test("151. Reverse Words in a String") {
    assert(ReverseWordsInString.reverseWords("the sky is blue") == "blue is sky the")
    assert(ReverseWordsInString.reverseWords("  hello world!  ") == "world! hello")
    assert(ReverseWordsInString.reverseWords("a good   example") == "example good a")
  }
  
  test("152. Maximum Product Subarray") {
    //    assert(MaxProduct.maxProduct(Array(2, 3, -2, 4)) == 6)
    //    assert(MaxProduct.maxProduct(Array(-2, 0, -1)) == 0)
    //    assert(MaxProduct.maxProduct(Array(-2, 3, -4)) == 24)
    assert(MaxProduct.maxProduct(Array(-4, -3, -2)) == 12)
  }
  
}
