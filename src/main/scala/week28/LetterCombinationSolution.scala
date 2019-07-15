package week28

/**
  * @author tang
  * @date 2019/07/13
  */
object LetterCombinationSolution {

  val digitMapping: Map[Char, Array[String]] = Map(
    '2' -> Array("a", "b", "c"),
    '3' -> Array("d", "e", "f"),
    '4' -> Array("g", "h", "i"),
    '5' -> Array("j", "k", "l"),
    '6' -> Array("m", "n", "o"),
    '7' -> Array("p", "q", "r", "s"),
    '8' -> Array("t", "u", "v"),
    '9' -> Array("w", "x", "y", "z")
  )

  def letterCombinations(digits: String): List[String] = {
    if (digits.length == 0) {
      List.empty[String]
    } else {
      combine(digits.map(digitMapping), 0, digits.length).toList
    }

  }

  def combine(sub: Seq[Array[String]], start: Int, size: Int): Array[String] = {
    if (size == 1) {
      sub(start)
    } else {
      sub(start).flatMap {
        s =>
          combine(sub, start + 1, size - 1).map {
            internal =>
              s + internal
          }
      }
    }
  }

}
