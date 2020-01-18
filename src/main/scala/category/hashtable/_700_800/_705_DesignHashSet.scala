package category.hashtable._700_800

/**
  * 705. Design HashSet
  */
class _705_DesignHashSet() {
  
  /** Initialize your data structure here. */
  val N      = 1000001
  val bucket = new Array[Boolean](N)
  
  def add(key: Int): Unit = {
    bucket(key) = true
  }
  
  def remove(key: Int): Unit = {
    bucket(key) = false
  }
  
  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    bucket(key)
  }
  
}