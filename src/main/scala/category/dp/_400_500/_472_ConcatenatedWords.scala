package category.dp._400_500


/**
  * 472. Concatenated Words
  */
object _472_ConcatenatedWords {
  
  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    if (words.length == 1) return Nil
    
    def ofTrie(inputs: Array[String]): Map[Char, Array[String]] = {
      inputs.filter(_.length >= 1).map { input =>
        input(0) -> input
      }.groupBy(_._1).map { case (k, list) => k -> list.map(_._2).sortBy(s => -1 * s.length) }
    }
    
    val trie = ofTrie(words)
    
    def search(word: String, depth: Int): Boolean = {
      if (word.isEmpty && depth == 0) return false
      if (word.isEmpty && depth != 0) return true
      val first = word(0)
      var anyOne = false
      val words = trie.getOrElse(first, return false)
      var curr = 0
      while (curr < words.length && !anyOne) {
        if (words(curr) == word && depth == 0 && !anyOne) {
          anyOne = false
        } else if (word.indexOf(words(curr)) == 0 && !anyOne) {
          anyOne = search(word.substring(words(curr).length), depth + 1)
        }
        curr += 1
      }
      anyOne
    }
    
    words.filter(search(_, 0)).toList
  }
}