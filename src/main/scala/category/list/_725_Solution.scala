package category.list

import category.timeline.week22.ListNode

import scala.collection.mutable.ArrayBuffer

/**
  * 725. Split Linked List in Parts
  *
  * [1,2,3,4]
  * 5
  * []
  * 1
  * [1]
  * 1
  * [1]
  * 2
  * [1,2]
  * 3
  * [1,2]
  * 2
  * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  * 3
  * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  * 2
  * []
  * 2
  * []
  * 3
  * [1]
  * 3
  */
object _725_Solution {
  def splitListToParts(root: ListNode, k: Int): Array[ListNode] = {
    def length(node: ListNode): Int = {
      var tmp = node
      var sz = 0
      while (tmp != null) {tmp = tmp.next; sz += 1}
      sz
    }
    
    
    def extract(node: ListNode, sz: Int): ListNode = {
      if (node == null) return null
      var p = 0
      var tmp, pre = node
      while (p < sz && tmp != null) {pre = tmp; tmp = tmp.next; p += 1}
      pre.next = null
      tmp
    }
    
    var len = length(root)
    var remain = k
    
    val buffer = new ArrayBuffer[ListNode]()
    var curr = root
    while (curr != null) {
      val part = len / remain + (if (len % remain == 0) 0 else 1)
      val next = extract(curr, part)
      buffer.append(curr)
      curr = next
      len -= part
      remain -= 1
    }
    while (buffer.length < k) buffer.append(null)
    buffer.toArray
  }
}