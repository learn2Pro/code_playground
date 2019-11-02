package category.timeline.week40

import java.util

class MinStack() {
  
  /** initialize your data structure here. */
  val data                                = new util.LinkedList[Int]
  var minMapping: java.util.Map[Int, Int] = new util.HashMap[Int, Int]()
  
  def push(x: Int): Unit = {
    data.add(x)
    minMapping.put(data.size(), Math.min(minMapping.getOrDefault(data.size() - 1, x), x))
  }
  
  def pop(): Unit = {
    data.getLast
    data.removeLast()
    minMapping.remove(data.size() + 1)
  }
  
  def top(): Int = {
    data.getLast
  }
  
  def getMin(): Int = {
    minMapping.get(data.size())
  }
  
}