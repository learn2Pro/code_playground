package category.time.week40

import category.time.week27.ListNode

/**
  * 143. Reorder List
  */
object ReorderList {
  
  def reorderList(head: ListNode): Unit = {
    if (head == null) return
    var len = 0
    var curr = head
    while (curr != null) {
      curr = curr.next
      len += 1
    }
    val half = (len - 1) / 2
    curr = head.next
    var before = head
    var idx = 0
    while (idx < half) {
      idx += 1
      before = before.next
      curr = curr.next
    }
    before.next = null
    var halfNode = reverse(curr)
    curr = head
    while (halfNode != null) {
      val tmp = curr.next
      val tmp0 = halfNode.next
      curr.next = halfNode
      halfNode.next = tmp
      halfNode = tmp0
      curr = tmp
    }
  }
  
  private def reverse(node: ListNode): ListNode = {
    var pre = node
    var next = nodeNext(node)
    var last: ListNode = null
    while (pre != null) {
      val tmp = nodeNext(next)
      if (next != null) next.next = pre
      if (pre != null) pre.next = last
      last = if (next != null) next else pre
      pre = tmp
      next = nodeNext(tmp)
    }
    last
  }
  
  private def nodeNext(node: ListNode): ListNode = {
    if (node == null) null
    else node.next
  }
  
  //  def reorderList(head: ListNode): Unit = {
  //    if (head != null) {
  //      var curr = head
  //      while (curr != null) {
  //        curr = reorderOnce(curr)
  //      }
  //    }
  //  }
  //
  //  private def reorderOnce(start: ListNode): ListNode = {
  //    var end = start.next
  //    var before = start
  //    while (end != null && end.next != null) {
  //      before = before.next
  //      end = end.next
  //    }
  //    if (start.next != end) {
  //      val tmp = start.next
  //      end.next = tmp
  //      start.next = end
  //      before.next = null
  //      tmp
  //    } else {
  //      null
  //    }
  //  }
}