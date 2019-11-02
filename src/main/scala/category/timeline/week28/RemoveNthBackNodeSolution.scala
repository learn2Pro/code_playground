package category.timeline.week28

import category.timeline.week27.ListNode

/**
  * @author tang
  * @date 2019/07/13
  */
object RemoveNthBackNodeSolution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var p0 = head
    var p1 = {
      var tmp = head
      for (_ <- 0 until n) {
        tmp = tmp.next
      }
      tmp
    }
    if (p1 == null) {
      head.next
    } else {
      while (p1.next != null) {
        p0 = p0.next
        p1 = p1.next
      }
      relink(p0)
      head
    }

  }

  def relink(pointer: ListNode) = {
    val first = pointer
    val third = if (pointer != null && pointer.next != null) {
      pointer.next.next
    } else {
      null
    }
    if (first != null) {
      first.next = third
    }
  }
}
