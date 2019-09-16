/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

import java.util

import scala.collection.mutable


/**
  *
  * @author derong.tdr
  * @version MinimumWindowSubstring.scala, v 0.1 2019年09月08日 21:07 tang Exp $
  */
object MinimumWindowSubstring {

  def minWindow(s: String, t: String): String = {
    if (s.length < t.length) return ""
    var right = 0
    var ans: (Int, Int) = (Int.MaxValue, 0)
    val charMapping = t.groupBy(c => c).mapValues(_.length)
    val filtered = s.zipWithIndex.filter(s => charMapping.contains(s._1))
    val window = Window()
    while (right < filtered.length) {
      window.add(filtered(right))
      while (window.size >= t.length && window.contains(charMapping)) {
        if (window.size != -1 && window.size < ans._1) {
          ans = (window.size, window.last._2)
        }
        //contract
        window.removeFirst
      }
      right += 1
    }
    if (ans._1 == Int.MaxValue) ""
    else s.slice(ans._2 - ans._1 + 1, ans._2 + 1)
  }

  case class Window() extends mutable.Queue[(Char, Int)] {
    val holder = new util.HashMap[Char, Int]()

    def add(input: (Char, Int)) = {
      this.enqueue(input)
      if (holder.containsKey(input._1)) {
        holder.put(input._1, holder.get(input._1) + 1)
      } else {
        holder.put(input._1, 1)
      }
    }

    def removeFirst: Unit = {
      val (removed, _) = this.dequeue()
      if (holder.get(removed) == 1) {
        holder.remove(removed)
      } else {
        holder.put(removed, holder.get(removed) - 1)
      }
    }

    def contains(s: Map[Char, Int]): Boolean = {
      s.forall { case (c, sum) =>
        holder.containsKey(c) && holder.get(c) >= sum
      }
    }

    override def size: Int = {
      if (this.isEmpty) 0
      else this.last._2 - this.head._2 + 1
    }
  }

}
