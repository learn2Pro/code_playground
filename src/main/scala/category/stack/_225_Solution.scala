package category.stack

import java.util

/**
  * 225. Implement Stack using Queues
  */
class _225_Solution() {
  
  /** Initialize your data structure here. */
  val lst = new util.LinkedList[Int]()
  
  /** Push element x onto stack. */
  def push(x: Int): Unit = {
    lst.add(x)
  }
  
  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = {
    lst.removeLast()
  }
  
  /** Get the top element. */
  def top(): Int = {
    lst.getLast
  }
  
  /** Returns whether the stack is empty. */
  def empty(): Boolean = {
    lst.isEmpty
  }
  
}