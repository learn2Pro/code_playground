package weekTest20

import org.scalatest.FunSuite
import category.time.week27.ListNode
import category.time.week29.TreeNode
import category.time.week37._

/**
  * @author tang
  *         6@date 2019/08/03
  */
class LeetCodeExamTestWeek36 extends FunSuite {
  test("79. Word Search") {
    assert(WordSearch.exist(Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    ), "ABCCED") == true)
    assert(WordSearch.exist(Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    ), "SEE") == true)
    assert(WordSearch.exist(Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    ), "ABCB") == false)
  }
  
  test("84. Largest Rectangle in Histogram") {
    assert(LargestRecInHistogram.largestRectangleArea(Array(2, 1, 5, 6, 2, 3)) == 10)
    assert(LargestRecInHistogram.largestRectangleArea(Array(1, 2, 3, 4, 5, 6)) == 12)
    assert(LargestRecInHistogram.largestRectangleArea(Array(6, 2, 3, 1, 5, 6)) == 10)
  }
  
  test("85. Maximal Rectangle") {
    assert(MaximalRectangle.maximalRectangle(
      Array(
        Array('1', '0', '1', '0', '0'),
        Array('1', '0', '1', '1', '1'),
        Array('1', '1', '1', '1', '1'),
        Array('1', '0', '0', '1', '0')
      )) == 6)
    assert(MaximalRectangle.maximalRectangle(
      Array(
        Array('1', '1')
      )) == 2)
    assert(MaximalRectangle.maximalRectangle(
      Array(
        Array('0', '1'),
        Array('0', '1')
      )) == 2)
    
    /**
      * [["0","0","0","1","0","1","0"],
      * ["0","1","0","0","0","0","0"],
      * ["0","1","0","1","0","0","1"],
      * ["0","0","1","1","0","0","1"],
      * ["1","1","1","1","1","1","0"],
      * ["1","0","0","1","0","1","1"],
      * ["0","1","0","0","1","0","1"],
      * ["1","1","0","1","1","1","0"],
      * ["1","0","1","0","1","0","1"],
      * ["1","1","1","0","0","0","0"]]
      */
    assert(MaximalRectangle.maximalRectangle(
      Array(
        Array('0', '0', '0', '1', '0', '1', '0'),
        Array('0', '1', '0', '0', '0', '0', '0'),
        Array('0', '1', '0', '1', '0', '0', '1'),
        Array('0', '0', '1', '1', '0', '0', '1'),
        Array('1', '1', '1', '1', '1', '1', '0'),
        Array('1', '0', '0', '1', '0', '1', '1'),
        Array('0', '1', '0', '0', '1', '0', '1'),
        Array('1', '1', '0', '1', '1', '1', '0'),
        Array('1', '0', '1', '0', '1', '0', '1'),
        Array('1', '1', '1', '0', '0', '0', '0')
      )) == 6)
    
    /**
      * [["1","1","1","1","1","1","1","1"],
      * ["1","1","1","1","1","1","1","0"],
      * ["1","1","1","1","1","1","1","0"],
      * ["1","1","1","1","1","0","0","0"],
      * ["0","1","1","1","1","0","0","0"]]
      */
    assert(MaximalRectangle.maximalRectangle(
      Array(
        Array('1', '1', '1', '1', '1', '1', '1', '1'),
        Array('1', '1', '1', '1', '1', '1', '1', '0'),
        Array('1', '1', '1', '1', '1', '1', '1', '0'),
        Array('1', '1', '1', '1', '1', '0', '0', '0'),
        Array('0', '1', '1', '1', '1', '0', '0', '0')
      )) == 21)
    
    
  }
  
  test("221. Maximal Square") {
    //    assert(MaximalSquare.maximalSquare(Array(
    //      Array('1', '0', '1', '0', '0'),
    //      Array('1', '0', '1', '1', '1'),
    //      Array('1', '1', '1', '1', '1'),
    //      Array('1', '0', '0', '1', '0')
    //    )) == 4)
    
    /**
      * [["1","1","1","0","0"],
    * ["1","1","1","0","0"],
      * ["1","1","1","1","1"],
      * ["0","1","1","1","1"],
      * ["0","1","1","1","1"],
      * ["0","1","1","1","1"]]
      */
    assert(MaximalSquare.maximalSquare(Array(
      Array('1', '1', '1', '0', '0'),
      Array('1', '1', '1', '0', '0'),
      Array('1', '1', '1', '1', '1'),
      Array('0', '1', '1', '1', '1'),
      Array('0', '1', '1', '1', '1'),
      Array('0', '1', '1', '1', '1')
    )) == 16)
  }
  
  test("86. Partition List") {
    val l0 = new ListNode(1)
    val l1 = new ListNode(4)
    val l2 = new ListNode(3)
    val l3 = new ListNode(2)
    val l4 = new ListNode(5)
    val l5 = new ListNode(2)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    assert(PartitionList.partition(l0, 3) == l0)
  }
  
  test("87. Scramble String") {
    //    assert(ScrambleString.isScramble("great", "rgeat") == true)
    assert(ScrambleString.isScramble("abb", "bba") == true)
  }
  
  test("89. Gray Code") {
    assert(GrayCode.grayCode(2) == List(0, 1, 3, 2))
    assert(GrayCode.grayCode(3) == List(0, 1, 3, 2, 6, 7, 5, 4))
    assert(GrayCode.grayCode(0) == List(0))
  }
  
  test("90. Subsets II") {
    println(SubsetsII.subsetsWithDup(Array(4, 4, 4, 1, 4)))
  }
  
  test("91. Decode Ways") {
    assert(DecodeWays.numDecodings("00") == 0)
    assert(DecodeWays.numDecodings("10") == 1)
    assert(DecodeWays.numDecodings("100") == 0)
    assert(DecodeWays.numDecodings("1000") == 0)
    assert(DecodeWays.numDecodings("1001") == 0)
  }
  
  test("92. Reverse Linked List II") {
    val l0 = new ListNode(1)
    val l1 = new ListNode(2)
    val l2 = new ListNode(3)
    val l3 = new ListNode(4)
    val l4 = new ListNode(5)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    println(ReverseLinkedListII.reverseBetween(l0, 2, 4))
    val l22 = new ListNode(3)
    val l23 = new ListNode(5)
    l22.next = l23
    println(ReverseLinkedListII.reverseBetween(l22, 1, 2))
  }
  
  test("93. Restore IP Addresses") {
    assert(RestoreIPAddresses.restoreIpAddresses("25525511135") == List("255.255.11.135", "255.255.111.35"))
    assert(RestoreIPAddresses.restoreIpAddresses("1111") == List("1.1.1.1"))
  }
  
  test("95. Unique Binary Search Trees II") {
    println(UniqueBinarySearchTreesII.generateTrees(3))
  }
  
  test("99. Recover Binary Search Tree") {
    //    val root = new TreeNode(1)
    //    val n0 = new TreeNode(2)
    //    val n1 = new TreeNode(3)
    //    root.left = n1
    //    n1.right = n0
    //    println(RecoverBinarySearchTree.recoverTree(root))
    val n0 = new TreeNode(1)
    val n1 = new TreeNode(2)
    val n2 = new TreeNode(3)
    val n3 = new TreeNode(4)
    n2.left = n0
    n2.right = n3
    n3.left = n1
    println(RecoverBinarySearchTree.recoverTree(n2))
  }
  
  test("101. Symmetric Tree") {
    //    val n0 = new TreeNode(1)
    //    val n1 = new TreeNode(2)
    //    val n2 = new TreeNode(2)
    //    n0.left = n1
    //    n0.right = n2
    //    assert(SymmetricTree.isSymmetric(n0))
    
    val n0 = new TreeNode(1)
    val n1 = new TreeNode(2)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(3)
    n0.left = n1
    n0.right = n2
    n1.right = n3
    n2.right = n4
    assert(SymmetricTree.isSymmetric(n0) == false)
  }
  
  test("102. Binary Tree Level Order Traversal") {
    val n0 = new TreeNode(1)
    val n1 = new TreeNode(2)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(3)
    n0.left = n1
    n0.right = n2
    n1.right = n3
    n2.right = n4
    assert(BinaryTreeLevelOrderTraversal.levelOrder(n0) == List(List(1), List(2, 2), List(3, 3)))
  }
  
  test("105. Construct Binary Tree from Preorder and Inorder Traversal") {
    val n0 = new TreeNode(3)
    val n1 = new TreeNode(9)
    val n2 = new TreeNode(20)
    val n3 = new TreeNode(15)
    val n4 = new TreeNode(7)
    n0.left = n1
    n0.right = n2
    n2.left = n3
    n2.right = n4
    assert(ReconstructBTree.buildTree(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7)) == n0)
  }
  
  test("111. Minimum Depth of Binary Tree") {
    val n0 = new TreeNode(1)
    val n1 = new TreeNode(2)
    n0.left = n1
    assert(BTreeMinDepth.minDepth(n0) == 2)
  }
}
