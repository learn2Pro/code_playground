package category.hashtable._600_700


/**
  * 648. Replace Words
  */
object _648_ReplaceWords {
  
  def replaceWords(dict: List[String], sentence: String): String = {
    class Trie {
      var word: String = _
      val children     = new Array[Trie](26)
    }
    
    val root = new Trie
    dict.foreach { word =>
      var curr = root
      word.foreach { c =>
        if (curr.children(c - 'a') == null) curr.children(c - 'a') = new Trie
        curr = curr.children(c - 'a')
      }
      curr.word = word
    }
    
    def find(s: String): String = {
      var curr = root
      s.foreach { c =>
        if (curr.children(c - 'a') == null || curr.word != null) return curr.word
        curr = curr.children(c - 'a')
      }
      null
    }
    
    val ans = new StringBuilder
    for (word <- sentence.split("\\s+")) {
      if (ans.nonEmpty) ans.append(" ")
      ans.append(Option(find(word)).getOrElse(word))
    }
    ans.toString()
  }
}