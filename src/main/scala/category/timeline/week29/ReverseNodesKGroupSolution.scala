package category.timeline.week29

import category.timeline.week27.ListNode

/**
  * @author tang
  * @date 2019/07/21
  */
object ReverseNodesKGroupSolution {
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    if (head == null || head.next == null) return head
    var startNode = head
    val headGear = new ListNode(0)
    headGear.next = head
    var currHead = headGear
    var idx = 0
    while (startNode != null) {
      var end = startNode
      for (_ <- 0 until k - 1) {
        end = getNext(end)
      }
      if (end != null) {
        val (last, curr) = reverseGroup(startNode, k)
        currHead.next = last
        currHead = startNode
        startNode = curr
      } else {
        startNode = null
      }
      idx += 1
    }
    headGear.next
  }

  /**
    * reverse 当前分组
    *
    * @param start
    * @param k
    */
  def reverseGroup(start: ListNode, k: Int) = {
    var last = start
    var curr = start.next
    var tmp = null.asInstanceOf[ListNode]
    for (_ <- 0 until k - 1 if curr != null) {
      tmp = getNext(curr)
      curr.next = last
      last = curr
      curr = tmp
    }
    val nextGroup = curr
    start.next = nextGroup
    last -> nextGroup
  }

  def getNext(curr: ListNode) = {
    if (curr == null) {
      null
    } else {
      curr.next
    }
  }
}
