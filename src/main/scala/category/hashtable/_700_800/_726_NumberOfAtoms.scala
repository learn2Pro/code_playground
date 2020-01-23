package category.hashtable._700_800


/**
  * 726. Number of Atoms
  */
object _726_NumberOfAtoms {
  
  import scala.collection.mutable.ArrayBuffer
  
  def countOfAtoms(formula: String): String = {
    val stack = new scala.collection.mutable.Stack[(String, Int)]
    val N = formula.length
    var i = 0
    while (i < N) {
      /*find atom*/
      formula(i) match {
        case c@'(' =>
          stack.push((c.toString, 0))
          i += 1
        case c@')' =>
          var curr = i + 1
          while (curr < N && Character.isDigit(formula(curr))) curr += 1
          val multi = if (curr == i + 1) 1 else formula.substring(i + 1, curr).toInt
          val buffer = new ArrayBuffer[(String, Int)]()
          while (stack.nonEmpty && stack.top._1 != "(") {
            val pop = stack.pop()
            buffer.append((pop._1, pop._2 * multi))
          }
          stack.pop()
          buffer.foreach(stack.push)
          i = curr
        case _ =>
          var curr = i + 1
          while (curr < N && Character.isLowerCase(formula(curr))) curr += 1
          val k = formula.substring(i, curr)
          val size = if (curr < N && Character.isDigit(formula(curr))) {
            val start = curr
            while (curr < N && Character.isDigit(formula(curr))) curr += 1
            formula.substring(start, curr).toInt
          } else {
            1
          }
          stack.push((k, size))
          i = curr
      }
    }
    val grouped = stack.groupBy(_._1).mapValues(_.map(_._2).sum).toArray
    grouped.sortBy(_._1).map { case (k, size) =>
      if (size == 1) k else k + size
    }.mkString
  }
}