package category.design

/**
  * 641. Design Circular Deque
  */
class MyCircularDeque(_k: Int) {
  
  /** Initialize your data structure here. Set the size of the deque to be k. */
  val elements  = new Array[Int](_k)
  var size: Int = 0
  
  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  def insertFront(value: Int): Boolean = {
    if (isFull()) return false
    System.arraycopy(elements, 0, elements, 1, size)
    elements(0) = value
    size += 1
    true
  }
  
  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  def insertLast(value: Int): Boolean = {
    if (isFull()) return false
    elements(size) = value
    size += 1
    true
  }
  
  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  def deleteFront(): Boolean = {
    if (isEmpty()) return false
    System.arraycopy(elements, 1, elements, 0, size - 1)
    size -= 1
    true
  }
  
  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  def deleteLast(): Boolean = {
    if (isEmpty()) return false
    size -= 1
    true
  }
  
  /** Get the front item from the deque. */
  def getFront(): Int = {
    if (isEmpty()) return -1
    elements.head
  }
  
  /** Get the last item from the deque. */
  def getRear(): Int = {
    if (isEmpty()) return -1
    elements(size - 1)
  }
  
  /** Checks whether the circular deque is empty or not. */
  def isEmpty(): Boolean = {
    size == 0
  }
  
  /** Checks whether the circular deque is full or not. */
  def isFull(): Boolean = {
    size == _k
  }
  
}