package category.hashtable._700_800

/**
  * 706. Design HashMap
  */
class _706_DesignHashMap() {
  
  /** Initialize your data structure here. */
  val N                  = 1000001
  val bucket: Array[Int] = Array.tabulate(N)(_ => -1)
  
  
  /** value will always be non-negative. */
  def put(key: Int, value: Int) {
    bucket(key) = value
  }
  
  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = {
    bucket(key)
  }
  
  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int) {
    bucket(key) = -1
  }
  
}