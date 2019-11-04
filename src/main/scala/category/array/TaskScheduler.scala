package category.array


/**
  * 621. Task Scheduler
  */
object TaskScheduler {
  /*use idle slots*/
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    var map = new Array[Int](26)
    tasks.foreach { c =>
      map(c - 'A') += 1
    }
    map = map.sorted
    val maxVal = map(25) - 1
    var idle = maxVal * n
    for (i <- 0 until map.length - 1 if map(i) != 0) {
      idle -= Math.min(map(i), maxVal)
    }
    if (idle < 0) tasks.length else idle + tasks.length
  }
  
  /*use sort*/
  def leastIntervalV0(tasks: Array[Char], n: Int): Int = {
    var map = new Array[Int](26)
    tasks.foreach { c =>
      map(c - 'A') += 1
    }
    map = map.sorted
    var time = 0
    while (map(25) > 0) {
      var idx = 0
      while (idx <= n && map(25) > 0) {
        if (idx < 26 && map(25 - idx) > 0) map(25 - idx) -= 1
        time += 1
        idx += 1
      }
      map = map.sorted
    }
    time
  }
  
  //
  //  import scala.collection.mutable.ArrayBuffer
  //
  //  def leastInterval(tasks: Array[Char], n: Int): Int = {
  //    val mapping = new ArrayBuffer[(Char, Int)]()
  //    mapping.appendAll(tasks.groupBy(identity).map { case (k, arr) => (k, arr.length) }.toArray.sortBy(_._2))
  //    var mappingLength = mapping.size
  //
  //    def decrement(size: Int): Int = {
  //      var remain = 0
  //      for (i <- mapping.indices) {
  //        if (remain > size) return remain
  //        val (k, v) = mapping(i)
  //        if (v > 0) {
  //          mapping(i) = (k, v - 1)
  //          if (v - 1 == 0) mappingLength -= 1
  //          remain += 1
  //        }
  //      }
  //      if (mappingLength == 0) size else size + 1
  //    }
  //
  //    var taskCount = 0
  //    while (mappingLength > 0) {
  //      taskCount += decrement(n)
  //    }
  //    taskCount
  //  }
}