package category.twopointer

import category.timeline.week22.ListNode

/**
  * 234. Palindrome Linked List
  */
object _234_Solution {
  def isPalindrome(head: ListNode): Boolean = {
    def length(node: ListNode): Int = {
      var tmp = node
      var sz = 0
      while (tmp != null) {
        tmp = tmp.next
        sz += 1
      }
      sz
    }
    
    val size = length(head)
    var n = head
    var last = head
    for (_ <- 0 until size / 2 + size % 2) {last = n; n = n.next}
    while (n != null) {val tmp = n.next; n.next = last; last = n; n = tmp}
    n = head
    for (_ <- 0 until size / 2) {
      if (n._x != last._x) return false
      n = n.next
      last = last.next
    }
    true
  }
  
  //  def isPalindrome(head: ListNode): Boolean = {
  //    val lst = new util.ArrayList[Int]
  //    var node = head
  //    while (node != null) {
  //      lst.add(node._x)
  //      node = node.next
  //    }
  //    var p0 = 0
  //    var p1 = lst.size() - 1
  //    while (p0 < p1) {
  //      if (lst.get(p0) != lst.get(p1)) return false
  //      p0 += 1
  //      p1 -= 1
  //    }
  //    true
  //  }
}