package category.bitmanipulation


/**
  * 784. Letter Case Permutation
  */
object LetterCasePermu {
  val digits: Set[Char] = Set('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  
  //  def letterCasePermutation(S: String): List[String] = {
  //
  //    import scala.annotation.tailrec
  //    @tailrec
  //    def backTrack(s: String, last: List[String]): List[String] = {
  //      /*last digit*/
  //      if (s.length == 0) return last
  //      /*last letter*/
  //      val firstChar = s(0)
  //      if (digits.contains(firstChar)) {
  //        backTrack(s.slice(1, s.length), last.map(_ + firstChar))
  //      } else {
  //        backTrack(s.slice(1, s.length), last.flatMap { prefix =>
  //          Iterator(prefix + firstChar.toUpper, prefix + firstChar.toLower)
  //        })
  //      }
  //    }
  //
  //    if (S == null || S.isEmpty) return Nil
  //    val firstStr = S.slice(0, 1)
  //    backTrack(S.slice(1, S.length), List(firstStr.toLowerCase, firstStr.toUpperCase).distinct)
  //  }
  
  def letterCasePermutation(S: String): List[String] = {
    if (S.length == 0) return Nil
    S.foldLeft(List("")) { case (z, c) =>
      val chs = if (!c.isLetter) List(c) else List(c.toLower, c.toUpper)
      for {
        s <- z
        c <- chs
      } yield s + c
    }
  }
}