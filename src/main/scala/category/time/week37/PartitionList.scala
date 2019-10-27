package category.time.week37

import category.time.week27.ListNode

object PartitionList {
  def partition(head: ListNode, x: Int): ListNode = {
    if (head == null || head.next == null) return head
    val greater = new ListNode
    var greaterCurr = greater
    val lower = new ListNode
    var parent = lower
    parent.next = head
    var curr = head
    while (curr != null) {
      if (curr._x >= x) {
        greaterCurr.next = curr
        parent.next = curr.next
        curr = curr.next
        greaterCurr = greaterCurr.next
      } else {
        parent = curr
        curr = curr.next
      }
    }
    parent.next = greater.next
    greaterCurr.next = null
    lower.next
  }
}