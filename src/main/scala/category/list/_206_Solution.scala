package category.list

import category.timeline.week22.ListNode

/**
  * 206. Reverse Linked List
  * [1,2,3,4,5]
  * []
  */
object _206_Solution {
  def reverseList(head: ListNode): ListNode = {
    if (head == null) return head
    var last = head
    var curr = head.next
    while (curr != null) {
      val tmp = curr.next
      curr.next = last
      last = curr
      curr = tmp
    }
    head.next = null
    last
  }
}