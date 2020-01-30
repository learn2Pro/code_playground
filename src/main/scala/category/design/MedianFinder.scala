package category.design

/**
  * 295. Find Median from Data Stream
  *
  * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
  * [[],[1],[2],[],[3],[],[4],[],[5],[],[6],[],[7],[],[8],[]]
  * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
  * [[],[1],[],[2],[],[3],[],[4],[],[5],[],[6],[],[7],[],[8],[]]
  * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
  * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
  * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
  * [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
  * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
  * [[],[12],[],[10],[],[13],[],[11],[],[5],[],[15],[],[1],[],[11],[],[6],[],[17],[],[14],[],[8],[],[17],[],[6],[],[4],[],[16],[],[8],[],[10],[],[2],[],[12],[],[0],[]]
  */
class MedianFinder() {
  /** initialize your data structure here. */
  val large, small = new java.util.PriorityQueue[Long]()
  
  def addNum(num: Int): Unit = {
    large.add(num)
    small.add(-large.poll())
    if (large.size() < small.size()) large.add(-small.poll())
  }
  
  def findMedian(): Double = {
    if (large.size() > small.size()) large.peek()
    else (large.peek() - small.peek()) / 2.0
  }
  
  //  /** initialize your data structure here. */
  //  val N          = 100
  //  var size, last = 0
  //  var lst        = new mutable.HashMap[Int, Int]()
  //
  //  def addNum(num: Int): Unit = {
  //    size += 1
  //    last = num
  //    lst.put(num, lst.getOrElse(num, 0) + 1)
  //  }
  //
  //  def findMedian(): Double = {
  //    if (size == 1) return last
  //    var mid = size / 2
  //    var i = 0
  //    val sorted = lst.keys.toArray.sorted
  //    while (i < sorted.length && mid > 0) {
  //      mid -= lst(sorted(i))
  //      i += 1
  //    }
  //    val previous = i - 1
  //    val next = i
  //    if (size % 2 == 0 && mid == 0) (sorted(next) + sorted(previous)) / 2.0
  //    else if (size % 2 == 1 && mid == 0) sorted(next)
  //    else sorted(previous)
  //  }
}