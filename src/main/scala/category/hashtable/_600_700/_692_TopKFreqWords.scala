package category.hashtable._600_700



/**
  * 692. Top K Frequent Words
  */
object _692_TopKFreqWords {
  import scala.collection.mutable
  def topKFrequent(words: Array[String], k: Int): List[String] = {
    val entity = words.groupBy(identity).mapValues(_.length)
    val queue = new mutable.PriorityQueue[(String, Int)]()(new Ordering[(String, Int)] {
      override def compare(x: (String, Int), y: (String, Int)): Int = if (x._2 != y._2) {
        y._2 - x._2
      } else {
        y._1.compareTo(x._1)
      }
    })
    for (i <- entity) {
      queue.enqueue(i)
      if (queue.size > k) queue.dequeue()
    }
    var ans: List[String] = Nil
    while (queue.nonEmpty) ans ::= queue.dequeue()._1
    ans
  }
}