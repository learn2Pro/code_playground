package category.list

import category.timeline.week22.ListNode

/**
  * 445. Add Two Numbers II
  *
  * [7,2,4,3]
  * [5,6,4]
  * [1]
  * [0]
  * [0]
  * [12]
  * [0]
  * [0]
  * [5]
  * [5]
  */
object _445_Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def toString(node: ListNode): String = {
      val sb = new StringBuilder
      var tmp = node
      while (tmp != null) {
        sb.append(tmp.x)
        tmp = tmp.next
      }
      sb.toString()
    }
    
    def flip(s: String, sz: Int): String = {
      val sb = new StringBuilder
      for (_ <- 0 until sz) sb.append('0')
      sb.append(s).toString()
    }
    
    def add(s0: String, s1: String): String = {
      val sb = new StringBuilder
      val (left, right) = if (s0.length < s1.length) {
        flip(s0, s1.length - s0.length) -> s1
      } else {
        flip(s1, s0.length - s1.length) -> s0
      }
      var carry = 0
      for (i <- Range(left.length - 1, -1, -1)) {
        val c0 = left(i)
        val c1 = right(i)
        val sum = c0 - '0' + c1 - '0' + carry
        sb.append(sum % 10)
        carry = sum / 10
      }
      if (carry != 0) sb.append(carry)
      sb.reverse.toString()
    }
    
    def toList(s: String): ListNode = {
      if (s.isEmpty) return null
      val curr = new ListNode(s(0) - '0')
      curr.next = toList(s.substring(1))
      curr
    }
    
    toList(add(toString(l1), toString(l2)))
  }
}