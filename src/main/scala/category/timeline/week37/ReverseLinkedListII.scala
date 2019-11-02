package category.timeline.week37

import category.timeline.week27.ListNode

/**
  * 92. Reverse Linked List II
  */
object ReverseLinkedListII {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (head == null || head.next == null) return head
    if (m == n) return head
    var i = 0
    val parent = new ListNode()
    var node = parent
    node.next = head
    while (i < m - 1) {
      node = node.next
      i += 1
    }
    val mNode = node
    val currNode = mNode.next
    while (i < n) {
      node = node.next
      i += 1
    }
    val nNode = node.next
    node.next = null
    reverse(mNode, nNode, currNode)
    parent.next
  }

  def reverse(head: ListNode, tail: ListNode, curr: ListNode): Unit = {
    var last = head
    var hop0 = curr
    var hop1 = if (curr == null) null else curr.next
    while (hop0 != null) {
      if (hop1 == null) {
        hop0.next = last
        last = hop0
        hop0 = null
      } else {
        val tmp = hop1.next
        hop1.next = hop0
        hop0.next = last
        last = hop1
        hop0 = tmp
        hop1 = if (tmp == null) null else tmp.next
      }
    }
    head.next = last
    if (curr != null) {
      curr.next = tail
    }
  }
}