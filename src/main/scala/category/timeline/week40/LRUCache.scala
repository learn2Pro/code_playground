package category.timeline.week40

import java.util

/**
  * 146. LRU Cache
  */
class LRUCache(_capacity: Int) {
  
  /**
    * queue
    */
  val queue = new util.LinkedList[Int]()
  /**
    * holder
    */
  val map   = new util.HashMap[Int, Int]()
  
  def get(key: Int): Int = {
    refresh(key)
    evict
    map.getOrDefault(key, -1)
  }
  
  def put(key: Int, value: Int): Unit = {
    map.put(key, value)
    push(key)
    evict
  }
  
  private def refresh(key: Int): Boolean = {
    if (queue.contains(key)) {
      queue.removeFirstOccurrence(key)
      queue.offer(key)
      true
    } else {
      false
    }
  }
  
  private def push(key: Int): Unit = {
    if (!refresh(key)) {
      queue.offer(key)
    }
  }
  
  private def evict: Unit = {
    while (queue.size() > _capacity) {
      map.remove(queue.poll())
    }
  }
  
}