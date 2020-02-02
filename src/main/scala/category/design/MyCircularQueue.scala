package category.design

class MyCircularQueue(_k: Int) {
  
  /** Initialize your data structure here. Set the size of the queue to be k. */
  val elements  = new Array[Int](_k)
  var size: Int = 0
  
  /** Insert an element into the circular queue. Return true if the operation is successful. */
  def enQueue(value: Int): Boolean = {
    if (isFull()) return false
    elements(size) = value
    size += 1
    true
  }
  
  /** Delete an element from the circular queue. Return true if the operation is successful. */
  def deQueue(): Boolean = {
    if (isEmpty()) return false
    System.arraycopy(elements, 1, elements, 0, size - 1)
    size -= 1
    true
  }
  
  /** Get the front item from the queue. */
  def Front(): Int = {
    if (isEmpty()) return -1
    elements.head
  }
  
  /** Get the last item from the queue. */
  def Rear(): Int = {
    if (isEmpty()) return -1
    elements(size - 1)
  }
  
  /** Checks whether the circular queue is empty or not. */
  def isEmpty(): Boolean = {
    size == 0
  }
  
  /** Checks whether the circular queue is full or not. */
  def isFull(): Boolean = {
    size == _k
  }
  
}