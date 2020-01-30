package category.stack

import java.util

/**
  * 636. Exclusive Time of Functions
  *
  * 2
  * ["0:start:0","1:start:2","1:end:5","0:end:6"]
  * 5
  * ["0:start:0","1:start:1","2:start:2","3:start:3","3:end:4","2:end:5","1:end:6","4:start:7","4:end:8","0:end:9"]
  * 1
  * ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
  */
object _636_Solution {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val ans = new Array[Int](n)
    val stack = new util.Stack[(Int, Int)]()
    val gap = new util.Stack[Int]()
    logs.foreach { s =>
      val splits = s.split(':')
      val id = splits(0).toInt
      val ts = splits(2).toInt
      splits(1) match {
        case "start" =>
          gap.push(0)
          stack.push((id, ts))
        case "end" =>
          val elapse = ts - stack.pop()._2 + 1
          val g = gap.pop()
          ans(id) += elapse - g
          if (!gap.isEmpty) gap.push(gap.pop() + elapse)
      }
    }
    ans
  }
}