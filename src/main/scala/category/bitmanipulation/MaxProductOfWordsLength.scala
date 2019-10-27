package category.bitmanipulation


/**
  * 318. Maximum Product of Word Lengths
  */
object MaxProductOfWordsLength {
  def maxProduct(words: Array[String]): Int = {
    import java.util
    val bitSetMapping = new util.HashMap[String, Int]()
    
    def bitSet(word: String): Int = {
      word.map { c =>
        1 << (c - 'a')
      }.reduce(_ | _)
    }
    
    def init = {
      words.foreach { word =>
        if (!bitSetMapping.containsKey(word) && word.nonEmpty) bitSetMapping.put(word, bitSet(word))
      }
    }
    
    def isSimilar(word: String, other: String): Boolean = {
      word.nonEmpty && other.nonEmpty && (bitSetMapping.get(word) & bitSetMapping.get(other)) == 0
    }
    
    val len = words.length
    if (words.isEmpty) return 0
    init
    var ans = 0
    for (i <- 0 until len)
      for (j <- i + 1 until len if isSimilar(words(i), words(j))) {
        ans = Math.max(ans, words(i).length * words(j).length)
      }
    ans
  }
}