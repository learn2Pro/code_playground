/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week32

import java.util.{HashMap => JHashMap}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author derong.tdr
  * @version ConcatenationOfAllWordsSolution.scala, v 0.1 2019年08月07日 22:16 tang Exp $
  */
object ConcatenationOfAllWordsV2Solution {

  /**
    * f(n+len) = f(n)+ f[0,len]==f[n,n+len]
    *
    * @param s
    * @param words
    * @return
    */
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (s == null || s.isEmpty) return List.empty[Int]
    if (words == null || words.isEmpty) return List.empty[Int]

    val ans = new ArrayBuffer[Int]()
    val wordLen = words.head.length
    val dp = new Array[Boolean](s.length)
    val window = new mutable.Queue[String]

    val holder = WordHolder.create(words)
    for (i <- 0 until words.head.length) {
      var coordinator = i
      window.clear()
      while (coordinator + wordLen <= s.length) {
        window.enqueue(s.substring(coordinator, coordinator + wordLen))
        if (window.length == words.length) {
          if (isMatch(window, holder, dp, coordinator, s, wordLen)) {
            ans.append(coordinator + wordLen - wordLen * window.length)
          }
          window.dequeue()
        }
        coordinator += wordLen
      }
    }

    ans.toList
  }

  def isMatch(window: mutable.Queue[String],
              holder: WordHolder,
              dp: Array[Boolean],
              coordinator: Int,
              s: String,
              wordLen: Int): Boolean = {
    //dp
    if (coordinator - 1 >= 0 && dp(coordinator - 1)) {
      val prefix = s.substring(coordinator - window.length * wordLen, coordinator - window.length * wordLen + wordLen)
      val suffix = window.last
      val rs = prefix == suffix
      dp(coordinator + wordLen - 1) = rs
      rs
    } else {
      val copy = holder.clone().asInstanceOf[WordHolder]
      var notEnd = true
      for (word <- window if notEnd) {
        if (!copy.contains(word)) notEnd = false
        else copy.minus(word)
      }
      dp(coordinator + wordLen - 1) = copy.isEmpty
      dp(coordinator + wordLen - 1)
    }
  }


}

object WordHolder {
  def create(words: Array[String]): WordHolder = {
    val holder = new WordHolder()
    words.foreach(holder.add)
    holder
  }
}

case class WordHolder(lookUp: JHashMap[String, Int] = new JHashMap[String, Int]()) {

  override def clone(): AnyRef = {
    WordHolder(lookUp.clone().asInstanceOf[JHashMap[String, Int]])
  }

  def isEmpty: Boolean = lookUp.isEmpty

  def contains(word: String): Boolean = lookUp.containsKey(word)

  /**
    * 添加
    *
    * @param word
    */
  def add(word: String): Unit = {
    if (lookUp.containsKey(word)) {
      val add = lookUp.get(word) + 1
      lookUp.put(word, add)
    } else {
      lookUp.put(word, 1)
    }
  }

  /**
    * 删除
    *
    * @param word
    */
  def minus(word: String): Unit = {
    if (lookUp.containsKey(word)) {
      val minus = lookUp.get(word) - 1
      if (minus == 0) {
        lookUp.remove(word)
      } else {
        lookUp.put(word, minus)
      }
    }
  }
}

