package category.bitmanipulation


/**
  * 756. Pyramid Transition Matrix
  */
object PyramidMatrix {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    val extractor = allowed.groupBy(_.slice(0, 2)).map { case (k, list) =>
      k -> list.map(_ (2)).toSet
    }
    
    import scala.annotation.tailrec
    @tailrec
    def traversal(states: Seq[Set[Char]], str: Iterable[String]): Iterable[String] = {
      if (states.isEmpty) return str
      val partial = states.head.flatMap { c =>
        str.map(_ + c)
      }
      traversal(states.slice(1, states.length), partial)
    }
    
    def backTrack(curr: String): Boolean = {
      if (curr.length == 1) return true
      val len = curr.length
      traversal(for (i <- 0 until len - 1) yield {
        extractor.getOrElse(curr(i) + "" + curr(i + 1), return false)
      }, Seq("")).exists { str =>
        backTrack(str)
      }
    }
    
    backTrack(bottom)
    
  }
}