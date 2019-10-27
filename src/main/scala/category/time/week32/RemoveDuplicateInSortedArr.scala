package category.time.week32

import category.time.week27.ListNode

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object RemoveDuplicateInSortedArr {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var curr = head._x
    var node = head.next
    var parent = head
    while (node != null) {
      if (node._x == curr) {
        //parent -> node.next
        parent.next = node.next
        node = node.next
      } else {
        curr = node._x
        parent = node
        node = node.next
      }
    }
    head
  }
}
