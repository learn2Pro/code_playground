/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week37

import category.timeline.week27.ListNode

/**
  *
  * @author derong.tdr
  * @version RemoveDupInSortedList.scala, v 0.1 2019年09月13日 21:42 tang Exp $
  */
class RemoveDupInSortedList {
  import java.util
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var curr = head._x
    var node = head.next
    var parent = head
    val duplicates = new util.HashSet[Int]()
    while (node != null) {
      if (node._x == curr) {
        duplicates.add(node._x)
        //parent -> node.next
        parent.next = node.next
        node = node.next
      } else {
        curr = node._x
        parent = node
        node = node.next
      }
    }
    var ans = head
    node = head
    parent = null
    while (node != null) {
      if (duplicates.contains(node._x)) {
        if (parent == null) {
          ans = ans.next
        }
        else {
          parent.next = node.next
        }
      } else {
        parent = node
      }
      node = node.next
    }
    ans
  }

}
