/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week36


/**
  *
  * @author derong.tdr
  * @version SimplifyPath.scala, v 0.1 2019年09月08日 16:05 tang Exp $
  */
object SimplifyPath {

  import scala.collection.mutable

  def simplifyPath(path: String): String = {
    val stack = new mutable.Stack[String]
    var step = 0
    while (step < path.length) {
      if (path(step) == '/') {
        step += 1
      } else {
        val opOrDir = getCharsBetweenSlash(step, path)
        opOrDir match {
          case ".." =>
            if (stack.nonEmpty) stack.pop()
          case "." =>
          case _ =>
            stack.push(opOrDir)
        }
        step += opOrDir.length
      }
    }
    "/" + stack.reverse.mkString("/")
  }

  def getCharsBetweenSlash(idx: Int, path: String) = {
    var ans = ""
    var tmp = idx
    while (tmp < path.length && path(tmp) != '/') {
      ans += path(tmp)
      tmp += 1
    }
    ans
  }
}
