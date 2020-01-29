package category.greedy

/**
  * 630. Course Schedule III
  */
object _630_Solution {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    val sorted = courses.sortWith { case (_@Array(_, t0), _@Array(_, t1)) => t0 < t1 }
    val heap = new java.util.PriorityQueue[Int](new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = y - x
    })
    var end = sorted(0).head
    for (i <- 1 until sorted.length) {
      end += sorted(i).head
      heap.add(sorted(i).head)
      if (end > sorted(i).last) {
        end -= heap.poll()
      }
    }
    heap.size()
  }
}