package category.hashtable._400_500

/**
  * 500. Keyboard Row
  */
object _500_KeyboardRow {
  val arr = new Array[Int](256)
  "qwertyuiopQWERTYUIOP".foreach(arr(_) = 0)
  "asdfghjklASDFGHJKL".foreach(arr(_) = 1)
  "zxcvbnmZXCVBNM".foreach(arr(_) = 2)
  val pattern1 = "(Q|W|E|R|T|Y|U|I|O|P|q|w|e|r|t|y|u|i|o|p)*".r
  val pattern2 = "(A|S|D|F|G|H|J|K|L|a|s|d|f|g|h|j|k|l)*".r
  val pattern3 = "(Z|X|C|V|B|N|M|z|x|c|v|b|n|m)*".r
  
  def findWords(words: Array[String]): Array[String] = {
    
    words.map {
      case r@pattern1(_) => r
      case r@pattern2(_) => r
      case r@pattern3(_) => r
      case _ => null
    }.filter(s => s != null)
    //    words.filter { s =>
    //      val loc = arr(s(0))
    //      s.forall(arr(_) == loc)
    //    }
  }
}