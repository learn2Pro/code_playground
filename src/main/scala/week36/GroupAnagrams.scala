/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

import scala.collection.mutable.ArrayBuffer


/**
  *
  * @author derong.tdr
  * @version GroupAnagrams.scala, v 0.1 2019年09月04日 21:54 tang Exp $
  */
object GroupAnagrams {

  import java.util.{Map => JMap}

  import scala.collection.JavaConversions._

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val discriminator: JMap[String, ArrayBuffer[String]] = new java.util.HashMap[String, ArrayBuffer[String]]
    val indexedStrs = strs.map { s =>
      val idx = if (discriminator.containsKey(genKey(s))) {
        val buffer = discriminator.get(genKey(s))
        buffer += s
        discriminator.put(genKey(s), buffer)
      } else {
        discriminator.put(genKey(s), ArrayBuffer(s))
      }
      idx -> s
    }
    discriminator.values().map(_.toList).toList
  }

  def genKey(str: String): String = {
    str.sorted
  }


}
