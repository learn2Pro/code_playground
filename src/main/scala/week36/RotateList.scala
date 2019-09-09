/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

import week27.ListNode


/**
  *
  * @author derong.tdr
  * @version RotateList.scala, v 0.1 2019年09月07日 17:19 tang Exp $
  */
object RotateList {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null || k == 0) return head
    var p0 = head
    var curNode = head
    var i = 0
    var length = 0
    while (curNode != null) {
      length += 1
      curNode = curNode.next
    }
    val remain = k % length
    while (i < remain) {
      //cycle to the head
      p0 = p0.next
      i += 1
    }
    var last = head
    var lastlast = last
    var tail = p0
    while (p0 != null) {
      tail = p0
      lastlast = last
      last = last.next
      p0 = p0.next
    }
    if (tail != null) {
      tail.next = head
    }
    lastlast.next = null
    if (last == null) head else last
  }
}
