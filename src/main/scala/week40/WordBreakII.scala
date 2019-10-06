package week40



/**
  * 140. Word Break II
  */
object WordBreakII {
  import java.util
  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    if (s == null) return Nil
    val dict = new util.HashSet[String]()
    val dp = Array.tabulate[List[String]](s.length)(_ => null)
    var lengths: List[Int] = Nil
    for (word <- wordDict) {
      dict.add(word)
      lengths = word.length :: lengths
    }
    val lengthSet = lengths.toSet
    
    def backTrack(s: String, location: Int): List[String] = {
      if (location <= -1) return List("")
      if (dp(location) != null) return dp(location)
      val tmp = for (len <- lengthSet if location - len + 1 >= 0 && dict.contains(s.substring(location - len + 1, location + 1))) yield {
        val ans = backTrack(s, location - len).map(_ + " " + s.substring(location - len + 1, location + 1))
        ans
      }
      if (tmp.nonEmpty) {
        dp(location) = tmp.reduce(_ ++ _)
      } else {
        dp(location) = Nil
      }
      dp(location)
    }
    
    backTrack(s, s.length - 1).map { s =>
      s.substring(1)
    }
  }
  
  //  def wordBreak(s: String, wordDict: List[String]): List[String] = {
  //    if (s == null) return Nil
  //    val dict = new util.HashSet[String]()
  //    var lengths: List[Int] = Nil
  //    for (word <- wordDict) {
  //      dict.add(word)
  //      lengths = word.length :: lengths
  //    }
  //    val lengthSet = lengths.toSet
  //    val dp = Array.tabulate[List[String]](s.length)(_ => Nil)
  //
  //    def findNearest(idx: Int): Set[Int] = {
  //      var search: List[Int] = Nil
  //      for (len <- lengthSet if idx - len + 1 > 0 ) {
  //        search = (idx - len + 1) :: search
  //      }
  //      search.toSet
  //    }
  //
  //    for (i <- s.indices) {
  //      if (dict.contains(s.substring(0, i + 1))) {
  //        dp(i) = dp(i) ++ List(s.substring(0, i + 1))
  //      }
  //      for (location <- findNearest(i) if dict.contains(s.substring(location, i + 1))) {
  //        val result = dp(location - 1).map(_ + " " + s.substring(location, i + 1))
  //        dp(i) = dp(i) ++ result
  //      }
  //    }
  //    dp(s.length - 1)
  //  }
}