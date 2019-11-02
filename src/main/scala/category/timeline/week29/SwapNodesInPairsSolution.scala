package category.timeline.week29

import category.timeline.week27.ListNode

/**
  * @author tang
  * @date 2019/07/21
  */
object SwapNodesInPairsSolution {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var p0 = head
    var p1 = p0.next
    val ans = p1
    var currHead = new ListNode(0)
    currHead.next = head
    while (p0 != null && p1 != null) {
      val tmp = getNext(p1)
      p1.next = p0
      p0.next = tmp
      currHead.next = p1
      currHead = p0
      p0 = getNext(p0)
      p1 = getNext(p0)
    }
    ans
  }

  def getNext(curr: ListNode) = {
    if (curr == null) {
      null
    } else {
      curr.next
    }
  }
}
