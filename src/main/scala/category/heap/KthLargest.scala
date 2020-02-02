package category.heap

/**
  * 703. Kth Largest Element in a Stream
  */
class KthLargest(_k: Int, _nums: Array[Int]) {
  val minHeap = new java.util.PriorityQueue[Int]()
  _nums.foreach(add)
  
  def add(`val`: Int): Int = {
    minHeap.add(`val`)
    if (minHeap.size() > _k) minHeap.poll()
    minHeap.peek()
  }
  
}