package category.timeline.week37

import category.timeline.week27.ListNode
import category.timeline.week29.TreeNode


/**
  * 108. Convert Sorted Array to Binary Search Tree
  */
object SortedList2BST {
  def sortedListToBST(head: ListNode): TreeNode = {
    var curr = head
    var size = 0
    while (curr != null) {
      size += 1
      curr = curr.next
    }
    curr = head
    
    def buildInRange(start: Int, end: Int): TreeNode = {
      if (start > end) return null
      if (curr == null) return null
      val mid = start + (end - start + 1) / 2
      val left = buildInRange(start, mid - 1)
      val node = new TreeNode(curr.x)
      curr = curr.next
      node.right = buildInRange(mid + 1, end)
      node.left = left
      node
    }
    
    buildInRange(0, size - 1)
  }
}