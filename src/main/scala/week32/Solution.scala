package week32

object Solution {
        def findSubstring(s: String, words: Array[String]): List[Int] = {
      if (words.isEmpty || words.head.isEmpty || s.isEmpty) Nil
      else {
        var starts = scala.collection.mutable.ArrayBuffer[Int]()
        val wordCounts = words.groupBy(identity).map { case (key, value) => key -> value.length }
        val wordLen = words.head.length
        for (i <- words.head.indices) {
          val table = scala.collection.mutable.Map[String, Int](wordCounts.toSeq: _*)
          var counter = table.size
          var start = i
          var end = i

          while (end + wordLen - 1 < s.length) {
            val subStr = s.substring(end, end + wordLen)
            if (table.contains(subStr)) {
              val wordCount = table(subStr)
              table += subStr -> (wordCount - 1)
              if (wordCount - 1 == 0) {
                counter -= 1
              }
            }
            end += wordLen

            while (counter == 0) {
              if ((end - start) == wordLen * words.length) {
                starts += start
              }
              val subStr = s.substring(start, start + wordLen)
              if (table.contains(subStr)) {
                val wordCount = table(subStr)
                table += subStr -> (wordCount + 1)
                if (wordCount + 1 > 0) {
                  counter += 1
                }
              }
              start += wordLen
            }
          }

        }
        starts.toList
      }
    }

}