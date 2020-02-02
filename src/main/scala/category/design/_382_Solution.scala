package category.design

import category.timeline.week22.ListNode

import scala.collection.mutable.ArrayBuffer

/**
  * 382. Linked List Random Node
  *
  * @param _head
  */
class _382_Solution(_head: ListNode) {
  
  /** @param head The linked list's head.
    *             Note that the head is guaranteed to be not null, so it contains at least one node. */
  val buffer = new ArrayBuffer[Int]()
  var tmp    = _head
  while (tmp != null) {buffer.append(tmp.x); tmp = tmp.next}
  val rnd = new java.util.Random
  
  /** Returns a random node's value. */
  def getRandom(): Int = {
    buffer(rnd.nextInt(buffer.size))
  }
  
}