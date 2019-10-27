package weekTest20

import org.scalatest.FunSuite
import category.time.week27.ListNode
import category.time.week29._
import category.time.week30.{RemoveDuplicateFromSortedSolution, SundayStrStrSolution}

/**
  * @author tang
  * @date 2019/07/13
  */
class LeetCodeExamTestWeek29 extends FunSuite {

  /**
    * Normal palindrome is defined as a string that reads the same backwards as forwards, for example "abccba".
    * Chunked palindrome is defined as a string that you can split into chunks and it will form a palindrome.
    * For example, "volvo". You can split it into (vo)(l)(vo). Let A = "vo", B = "l", so the original string is ABA which is a palindrome.
    *
    * Given a string str, find the maximum number of chunks we can split that string to get a chuncked palindrome.
    */
  test("Chunked Palindrome") {
    assert(ChunkedPalindromeMaxSizeSolution.findPalindromeMaxSize("valve") == 1)
    assert(ChunkedPalindromeMaxSizeSolution.findPalindromeMaxSize("voabcvo") == 3)
    assert(ChunkedPalindromeMaxSizeSolution.findPalindromeMaxSize("volvolvo") == 5)
    assert(ChunkedPalindromeMaxSizeSolution.findPalindromeMaxSize("volvol") == 2)
    assert(ChunkedPalindromeMaxSizeSolution.findPalindromeMaxSize("aaaaaa") == 6)
  }

  test("Swap Nodes in Pairs") {
    val l0 = new ListNode(1)
    val l1 = new ListNode(2)
    val l2 = new ListNode(3)
    val l3 = new ListNode(4)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    SwapNodesInPairsSolution.swapPairs(l0)
  }

  test("Reverse Nodes in k-Group") {
    val l0 = new ListNode(1)
    val l1 = new ListNode(2)
    val l2 = new ListNode(3)
    val l3 = new ListNode(4)
    val l4 = new ListNode(5)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    ReverseNodesKGroupSolution.reverseKGroup(l0, 3)
  }

  test("Binary Tree Tilt") {
    val t0 = new TreeNode(1)
    val t1 = new TreeNode(2)
    val t2 = new TreeNode(3)
    t0.left = t1
    t0.right = t2
    BTreeTiltSolution.findTilt(t0)
  }

  test("Print Binary Tree") {
    val t0 = new TreeNode(3)
    val t1 = new TreeNode(1)
    val t2 = new TreeNode(5)
    val t3 = new TreeNode(0)
    val t4 = new TreeNode(2)
    val t5 = new TreeNode(4)
    val t6 = new TreeNode(6)
    val t7 = new TreeNode(3)
    t0.left = t1
    t0.right = t2
    t1.left = t3
    t1.right = t4
    t2.left = t5
    t2.right = t6
    t4.right = t7
    println(PrintBTreeSolution.printTree(t0))
  }

  test("Remove Duplicates from Sorted Array") {
    RemoveDuplicateFromSortedSolution.removeDuplicates(Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
  }

  test("Implement strStr()") {
    assert(SundayStrStrSolution.strStr("hello", "ll") == 2)
    assert(SundayStrStrSolution.strStr("ababababc", "abababc") == 2)
    assert(SundayStrStrSolution.strStr("aaaaa", "bba") == -1)
    assert(SundayStrStrSolution.strStr("aabaaabaaac", "aabaaac") == 4)
  }

}
