package category.list

import category.timeline.week22.ListNode

/**
  * 328. Odd Even Linked List
  * [1,2,3,4,5]
  * []
  * [1]
  * [1,2]
  * [1,2,3]
  * [1,2,3,4]
  */
object _328_Solution {
  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null || head.next.next == null) return head
    var head0, last = head
    var head1, join = head.next
    var size = 1
    while (head1 != null) {
      head0.next = head1.next
      last = head0
      head0 = head1
      head1 = head1.next
      size += 1
    }
    if (size % 2 == 0) last.next = join else head0.next = join
    head
  }
}