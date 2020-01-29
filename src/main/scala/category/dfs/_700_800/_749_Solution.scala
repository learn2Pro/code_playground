package category.dfs._700_800


/**
  * 749. Contain Virus
  */
object _749_Solution {
  
  import java.util
  
  import scala.collection.mutable.ArrayBuffer
  
  def containVirus(grid: Array[Array[Int]]): Int = {
    val M = grid.length
    val N = grid(0).length
    val shift = Array((1, 0), (-1, 0), (0, 1), (0, -1))
    
    
    def perimeters(): List[(List[(Int, Int)], Int)] = {
      val seen = new util.HashSet[(Int, Int)]()
      var ans: List[(List[(Int, Int)], Int)] = Nil
      for (i <- 0 until M)
        for (j <- 0 until N if !seen.contains((i, j)) && grid(i)(j) == 1) {
          var inner: List[(Int, Int)] = Nil
          
          def neighbour(x: Int, y: Int): Int = {
            var ans = 0
            shift.foreach { case (sx, sy) =>
              val p0 = sx + x
              val p1 = sy + y
              val border = p0 < 0 || p0 >= M || p1 < 0 || p1 >= N
              if (!border && grid(p0)(p1) == 0) ans += 1
            }
            ans
          }
          
          def dfs(x: Int, y: Int): Int = {
            if (seen.contains((x, y)) || grid(x)(y) != 1) return 0
            inner ::= ((x, y))
            seen.add((x, y))
            var nei = neighbour(x, y)
            shift.foreach { case (sx, sy) =>
              val p0 = sx + x
              val p1 = sy + y
              val border = p0 < 0 || p0 >= M || p1 < 0 || p1 >= N
              
              if (!border && !seen.contains((p0, p1))) {
                nei += dfs(p0, p1)
              }
            }
            nei
          }
          
          val perimeter = dfs(i, j)
          ans ::= (inner, perimeter)
        }
      ans
    }
    
    def choose(input: List[(Int, Int)]): Unit = {
      input.foreach { case (x, y) =>
        grid(x)(y) = -1
      }
    }
    
    def retract(input: List[(Int, Int)]): Unit = {
      input.foreach { case (x, y) =>
        grid(x)(y) = 1
      }
    }
    
    def spread(input: List[(List[(Int, Int)], Int)]): List[(Int, Int)] = {
      var ans: List[(Int, Int)] = Nil
      input.foreach { case (area, _) =>
        area.foreach { case (x, y) =>
          shift.foreach { case (sx, sy) =>
            val p0 = sx + x
            val p1 = sy + y
            val border = p0 < 0 || p0 >= M || p1 < 0 || p1 >= N
            if (!border && grid(p0)(p1) == 0 && grid(x)(y) == 1) {
              ans ::= (p0, p1)
              grid(p0)(p1) = 1
            }
          }
        }
      }
      ans
    }
    
    def unSpread(input: List[(Int, Int)]): Unit = {
      input.foreach { case (x, y) => grid(x)(y) = 0 }
    }
    
    /**
      * 1.perimeters
      * 2.choose
      * 3.spread
      * 4.back to 1
      */
    val save = new ArrayBuffer[(Int, Int)]()
    val infected = new ArrayBuffer[Int]()
    
    def track(walls: Int): Unit = {
      val p = perimeters()
      if (p.isEmpty) {
        var sum = 0
        grid.foreach(arr => sum += arr.count(_ == 0))
        save.append((sum, walls))
        return
      }
      p.foreach { case (virus, perimeter) =>
        choose(virus)
        val items = spread(p)
        track(walls + perimeter)
        retract(virus)
        unSpread(items)
      }
    }
    
    track(0)
    save.maxBy(_._1)._2
  }
}