/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36


/**
  *
  * @author derong.tdr
  * @version TextJustification.scala, v 0.1 2019年09月07日 19:13 tang Exp $
  */
object TextJustification {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val strategies: Array[Strategy] = Array(NormalLine(words), LastLine(words))
    Strategy.register(strategies)
    var ans: List[String] = Nil
    var pos = 0
    while (pos < words.length) {
      val (partial, step) = Strategy.choose(words, pos, maxWidth).genRow(pos, maxWidth)
      ans ++= List(partial)
      pos += step
    }
    ans
  }


  private case class NormalLine(words: Array[String]) extends Strategy {
    override def genRow(index: Int, maxWidth: Int): (String, Int) = {
      var pos = index
      var usedLength = 0
      while (pos < words.length && usedLength + words(pos).length <= maxWidth) {
        usedLength += (words(pos).length + 1)
        pos += 1
      }
      fillSpace(words.slice(index, pos), maxWidth - usedLength + 1) -> (pos - index)
    }

    private def fillSpace(words: Array[String], remain: Int): String = {
      val step = words.length
      if (step > 1) {
        val eachSpaceNum = remain / (step - 1)
        val headNeedAdd = remain % (step - 1)
        var ans = ""
        for (i <- 0 until step - 1) {
          ans += {
            if (i < headNeedAdd) words(i) + String.copyValueOf(Array.tabulate(eachSpaceNum + 2)(_ => ' '))
            else words(i) + String.copyValueOf(Array.tabulate(eachSpaceNum + 1)(_ => ' '))
          }
        }
        ans + words(step - 1)
      } else {
        words(0) + String.copyValueOf(Array.tabulate(remain)(_ => ' '))
      }
    }
  }

  private case class LastLine(words: Array[String]) extends Strategy {
    override def genRow(index: Int, maxWidth: Int): (String, Int) = {
      val effective = words.slice(index, words.length).mkString(" ")
      val remain = maxWidth - effective.length
      effective + String.copyValueOf(Array.tabulate(remain)(_ => ' ')) -> (words.length - index)
    }
  }

  trait Strategy {
    def words: Array[String]

    /**
      * combined word and steps
      */
    def genRow(index: Int, maxWidth: Int): (String, Int)
  }

  object Strategy {
    var strategies: Array[Strategy] = _

    def register(strategies: Array[Strategy]): Unit = {
      this.strategies = strategies
    }

    def choose(words: Array[String], pos: Int, maxWidth: Int): Strategy = {
      val whichOne = if (words.slice(pos, words.length).mkString(" ").length < maxWidth) {
        1
      } else {
        0
      }
      strategies(whichOne)
    }
  }

}


