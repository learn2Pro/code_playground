package category.timeline.week38

import org.scalatest.FunSuite
import category.timeline.week29.TreeNode

/**
  * @author tang
  *         6@date 2019/08/03
  */
class LeetCodeExamTestWeek38 extends FunSuite {
  test("114. Flatten Binary Tree to Linked List") {
    val l0 = new TreeNode(1)
    val l1 = new TreeNode(2)
    val l2 = new TreeNode(3)
    l0.left = l1
    l1.left = l2
    val ans = PreOrderLinkedList.flatten(l0)
    println("end")
  }
  
  test("115. Distinct Subsequences") {
    assert(DistinctSubsequences.numDistinct("rabbbit", "rabbit") == 3)
    assert(DistinctSubsequences.numDistinct("babgbag", "bag") == 5)
  }
  
  test("116. Populating Next Right Pointers in Each Node") {
    val populate = new PopulateNextNode
    val r0 = new category.timeline.week38.Node()
    r0.`val` = 6
    val r1 = new category.timeline.week38.Node()
    r1.`val` = 7
    val r2 = new category.timeline.week38.Node()
    r2.`val` = 8
    val r3 = new category.timeline.week38.Node()
    r3.`val` = 9
    val r4 = new category.timeline.week38.Node()
    r4.`val` = 10
    val r5 = new category.timeline.week38.Node()
    r5.`val` = 11
    val r6 = new category.timeline.week38.Node()
    r6.`val` = 12
    val r7 = new category.timeline.week38.Node()
    r7.`val` = 13
    val r8 = new category.timeline.week38.Node(2, r0, r1, null)
    val r9 = new category.timeline.week38.Node(3, r2, r3, null)
    val r10 = new category.timeline.week38.Node(4, r4, r5, null)
    val r11 = new category.timeline.week38.Node(5, r6, r7, null)
    val r12 = new category.timeline.week38.Node(0, r8, r9, null)
    val r13 = new category.timeline.week38.Node(1, r10, r11, null)
    val r14 = new category.timeline.week38.Node(1, r12, r13, null)
    populate.connect(r14)
    println("end")
  }
  
  test("117. Populating Next Right Pointers in Each Node II") {
    val r0 = new category.timeline.week38.Node()
    r0.`val` = 5
    val r1 = new category.timeline.week38.Node()
    r1.`val` = 1
    val r2 = new category.timeline.week38.Node()
    r2.`val` = 6
    val r3 = new category.timeline.week38.Node()
    r3.`val` = 8
    val r4 = new category.timeline.week38.Node(1, r0, r1, null)
    val r5 = new category.timeline.week38.Node(3, null, r2, null)
    val r6 = new category.timeline.week38.Node(-1, null, r3, null)
    val r7 = new category.timeline.week38.Node(2, r4, null, null)
    val r8 = new category.timeline.week38.Node(4, r5, r6, null)
    val r9 = new category.timeline.week38.Node(0, r7, r8, null)
    val populate = new PopulateNextNodeII
    val ans = populate.connect(r9)
    println("end")
  }
  
  test("122. Best Time to Buy and Sell Stock II") {
    //    assert(BestStrategyInStockIII.maxProfit(Array(3, 3, 5, 0, 0, 3, 1, 4)) == 6)
    assert(BestStrategyInStockIII.maxProfit(Array(6, 1, 3, 2, 4, 7)) == 7)
  }
  
  test("124. Binary Tree Maximum Path Sum") {
    val l0 = new TreeNode(-2)
    val l1 = new TreeNode(-1)
    l0.left = l1
    assert(BTreeMaxPathSum.maxPathSum(l0) == -1)
  }
  
  test("125. Valid Palindrome") {
    assert(ValidPalindrome.isPalindrome("0P") == false)
  }
  
  test("127. Word Ladder") {
    assert(WordLadder.ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log", "cog")) == 5)
  }
  
  test("126. Word Ladder II") {
    //    assert(WordLadderII.findLadders(
    //      "hit", "cog",
    //      List("hot", "dot", "dog", "lot", "log", "cog")
    //    ) == List(List("hit","hot","dot","dog","cog"),List("hit","hot","lot","log","cog")))
    assert(WordLadderII.findLadders(
      "a", "c",
      List("a", "b", "c")
    ) == List(List("a", "c")))
  }
  
  test("128. Longest Consecutive Sequence") {
    assert(LongestConsecutive.longestConsecutive(Array(100, 4, 200, 1, 3, 2)) == 4)
    assert(LongestConsecutive.longestConsecutive(Array(0, -1)) == 2)
    assert(LongestConsecutive.longestConsecutive(Array(1, 2, 3, 4, 5)) == 5)
  }
  
  test("129. Sum Root to Leaf Numbers") {
    val t0 = new TreeNode(1)
    val t1 = new TreeNode(0)
    val t2 = new TreeNode(3)
    t0.left = t1
    //    t0.right = t2
    assert(SumRoot2Leaf.sumNumbers(t0) == 10)
  }
  
  test("130. Surrounded Regions") {
    val arr = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'O', 'O', 'O'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'O', 'X', 'O')
    )
    val ans = SurroundedRegions.solve(arr)
    println("end")
  }
  
  test("131. Palindrome Partitioning") {
    assert(PalindromePartition.partition("aab") == List(List("a", "a", "b"), List("aa", "b")))
    assert(PalindromePartition.partition("bb") == List(List("bb"), List("b", "b")))
    assert(PalindromePartition.partition("efe") == List(List("efe"), List("e", "f", "e")))
    assert(PalindromePartition.partition("aefea") == List(List("aefea"), List("a", "e", "f", "e", "a"), List("a", "efe", "a")))
  }
  
  test("132. Palindrome Partitioning II") {
//    assert(PalindromePartitionII.minCut("") == 0)
//    assert(PalindromePartitionII.minCut("aaa") == 0)
//    assert(PalindromePartitionII.minCut("aab") == 1)
//    assert(PalindromePartitionII.minCut("aefea") == 0)
//    assert(PalindromePartitionII.minCut("aefeabb") == 1)
//    assert(PalindromePartitionII.minCut("ababababa") == 0)
//    assert(PalindromePartitionII.minCut("abcccb") == 1)
//    assert(PalindromePartitionII.minCut("ccaacabacb") == 3)
//    assert(PalindromePartitionII.minCut("cbbbcc") == 1)
    assert(PalindromePartitionII.minCut("ababbbabbaba") == 3)
  }
}
