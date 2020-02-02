package category.design

/**
  * 745. Prefix and Suffix Search
  *
  * ["WordFilter","f","f","f","f","f","f"]
  * [[["apple"]],["a","e"],["b",""],["a","el"],["a","le"],["",""],["","e"]]
  * ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
  * [[["abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"]],["","abaa"],["babbab",""],["ab","baaa"],["baaabba","b"],["abab","abbaabaa"],["","aa"],["","bba"],["","baaaaabbbb"],["ba","aabbbb"],["baaa","aabbabbb"]]
  */
//class WeightTrie {
//  var word  : String = _
//  val children       = new Array[WeightTrie](26)
//  var weight: Int    = -1
//
//  def insert(input: String, w: Int) = {
//    var curr = this
//    input.foreach { c =>
//      if (curr.children(c - 'a') == null) curr.children(c - 'a') = new WeightTrie
//      curr = curr.children(c - 'a')
//    }
//    curr.word = input
//    curr.weight = w
//  }
//
//  def search(partial: String): List[(String, Int)] = {
//    var curr = this
//    partial.foreach { c =>
//      curr = curr.children(c - 'a')
//      if (curr == null) return Nil
//    }
//    track(curr)
//  }
//
//  def track(node: WeightTrie): List[(String, Int)] = {
//    if (node == null) return Nil
//    val one = if (node.word != null) List((node.word, node.weight)) else Nil
//    one ++ node.children.flatMap(track)
//  }
//}

class WeightTrie {
  var word  : String = _
  val children       = new Array[WeightTrie](27)
  var weight: Int    = -1
  
  def getIndex(c: Char): Int = {
    if (c == '#') 26
    else c - 'a'
  }
  
  def insert(input: String, w: Int) = {
    var curr = this
    input.foreach { c =>
      if (curr.children(getIndex(c)) == null) curr.children(getIndex(c)) = new WeightTrie
      curr = curr.children(getIndex(c))
    }
    curr.word = input
    curr.weight = w
  }
  
  def search(partial: String): List[(String, Int)] = {
    var curr = this
    partial.foreach { c =>
      curr = curr.children(getIndex(c))
      if (curr == null) return Nil
    }
    track(curr)
  }
  
  def track(node: WeightTrie): List[(String, Int)] = {
    if (node == null) return Nil
    val one = if (node.word != null) List((node.word, node.weight)) else Nil
    one ++ node.children.flatMap(track)
  }
}

class WordFilter(_words: Array[String]) {
  val PREFIX = new WeightTrie
  for (i <- _words.indices) {
    for (j <- Range(_words(i).length - 1, -1, -1)) {
      PREFIX.insert(_words(i).substring(j, _words(i).length) + "#" + _words(i), i)
    }
    PREFIX.insert("#" + _words(i), i)
  }
  
  def f(prefix: String, suffix: String): Int = {
    val p = PREFIX.search(suffix + "#" + prefix)
    if (p.isEmpty) return -1
    p.maxBy(_._2)._2
  }
  
}

//class WordFilter(_words: Array[String]) {
//  val PREFIX = new WeightTrie
//  val SUFFIX = new WeightTrie
//  for (i <- _words.indices) {
//    PREFIX.insert(_words(i), i)
//  }
//  for (i <- _words.indices) {
//    SUFFIX.insert(_words(i).reverse, i)
//  }
//
//  def f(prefix: String, suffix: String): Int = {
//    val p = PREFIX.search(prefix)
//    if (p.isEmpty) return -1
//    val s = SUFFIX.search(suffix.reverse).map { case (word, w) => word.reverse -> w }
//    if (s.isEmpty) return -1
//    val intersect = p.intersect(s)
//    if (intersect.isEmpty) return -1
//    intersect.maxBy(_._2)._2
//  }
//
//}
