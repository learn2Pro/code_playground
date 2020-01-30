package category.stack

import java.util

/**
  * 232. Implement Queue using Stacks
  */
class _232_Solution() {
  
  /** Initialize your data structure here. */
  val stack0 = new util.Stack[Int]
  
  /** Push element x to the back of queue. */
  def push(x: Int): Unit = {
    stack0.push(x)
  }
  
  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    stack0.remove(0)
  }
  
  /** Get the front element. */
  def peek(): Int = {
    stack0.get(0)
  }
  
  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    stack0.isEmpty
  }
  
}