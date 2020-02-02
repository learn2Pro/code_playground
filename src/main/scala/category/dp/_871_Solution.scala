package category.dp

import scala.collection.mutable

/**
  * 871. Minimum Number of Refueling Stops
  */
object _871_Solution {
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
    val heap = new mutable.PriorityQueue[Int]()(new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = x - y
    })
    var tank = startFuel
    var ans, prev = 0
    (stations ++ Array(Array(target, 0))).foreach { case _@Array(location, capacity) =>
      tank -= (location - prev)
      while (heap.nonEmpty && tank < 0) {tank += heap.dequeue(); ans += 1}
      if (tank < 0) return -1
      heap.enqueue(capacity)
      prev = location
    }
    ans
  }
  
  //  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
  //    val N = stations.length
  //    val dp = new Array[Long](N + 1)
  //    dp(0) = startFuel
  //    /*N station*/
  //    for (i <- 0 until N)
  //    /*stop j times*/
  //      for (j <- Range(i, -1, -1)) {
  //        if (dp(j) >= stations(i)(0)) dp(j + 1) = Math.max(dp(j + 1), dp(j) + stations(i)(1))
  //      }
  //    for (i <- 0 to N) if (dp(i) >= target) return i
  //    -1
  //  }
}