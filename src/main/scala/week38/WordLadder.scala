package week38


/**
  * 127. Word Ladder
  */
object WordLadder {
  import java.util
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    val wordSet = wordList.toSet
    val used = new util.HashSet[String]()
    
    def next(word: String): Set[String] = {
      wordList.filter(in => !used.contains(in) && distance(in, word) == 1).toSet
    }
    
    def distance(word0: String, word1: String): Int = {
      word0.zip(word1).map { case (c0, c1) =>
        if (c0 == c1) 0 else 1
      }.sum
    }
    
    import scala.collection.JavaConversions._
    if (!wordSet.contains(endWord)) return 0
    var step = 0
    var firstStep = next(beginWord)
    while (firstStep.nonEmpty && !firstStep.contains(endWord)) {
      step += 1
      used.addAll(firstStep)
      firstStep = firstStep.flatMap(next)
    }
    if (firstStep.contains(endWord)) step+2 else 0
  }
  
  
}