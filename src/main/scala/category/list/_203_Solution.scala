package category.list

import category.timeline.week22.ListNode

/**
  * 203. Remove Linked List Elements
  */
object _203_Solution {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val root = new ListNode(`val` + 1)
    root.next = head
    var last = root
    var curr = root.next
    while (curr != null) {
      if (curr.x == `val`) {
        last.next = curr.next
        curr = last.next
      } else {
        last = curr
        curr = curr.next
      }
    }
    root.next
  }
}