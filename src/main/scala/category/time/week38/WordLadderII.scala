package category.time.week38

/**
  * 127. Word Ladder
  */
object WordLadderII {
  
  import java.util
  
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
    val wordSet = wordList.toSet
    val used0 = new util.HashSet[String]()
    val used1 = new util.HashSet[String]()
    
    def next(word: String, used: util.HashSet[String]): Set[String] = {
      wordList.filter(in => !used0.contains(in) && distance(in, word) == 1).toSet
    }
    
    def distance(word0: String, word1: String): Int = {
      word0.zip(word1).map { case (c0, c1) =>
        if (c0 == c1) 0 else 1
      }.sum
    }
    
    import scala.collection.JavaConversions._
    if (!wordSet.contains(endWord)) return Nil
    var left = List(List(beginWord))
    var right = List(List(endWord))
    var forward = next(beginWord, used0)
    var backward = next(endWord, used1)
    while (forward.nonEmpty && backward.nonEmpty && forward.intersect(backward).isEmpty) {
      used0.addAll(forward)
      used1.addAll(backward)
      left = left.flatMap { curr =>
        for (add <- forward if distance(curr.last, add) == 1) yield {
          curr ++ List(add)
        }
      }
      right = right.flatMap { curr =>
        for (add <- backward if distance(curr.last, add) == 1) yield {
          add :: curr
        }
      }
      forward = forward.flatMap(next(_, used0))
      backward = backward.flatMap(next(_, used1))
    }
    val intersect = forward.intersect(backward).toList
    if (intersect.nonEmpty) {
      val output = for (mid <- intersect ++ List(beginWord, endWord)) yield {
        for (l0 <- left; r0 <- right if distance(l0.last, mid) <= 1 && distance(r0.head, mid) <= 1) yield {
          (l0 ++ List(mid) ++ r0).distinct
        }
      }
      output.flatten.distinct
    } else Nil
  }
  
  
}