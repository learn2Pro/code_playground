/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week34

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author derong.tdr
  * @version WildCardMatching.scala, v 0.1 2019年08月25日 10:52 tang Exp $
  */
object WildCardMatching {
  def isMatch(s: String, p: String): Boolean = {
    val head = compile(p)
    search(s, head)
  }

  def compile(p: String): State = {
    val head: State = State('^', -1)
    var last: ArrayBuffer[State] = ArrayBuffer(head)
    var idx = 0
    val len = p.length
    while (idx < len) {
      val (s, hop) = p(idx) match {
        case '*' =>
          AsteriskStrategy.plan(last, p, idx)
        case _ =>
          DefaultStrategy.plan(last, p, idx)
      }
      last = s
      idx += hop
    }
    //fill tail
    last.foreach {
      state =>
        if (state.c != '$') {
          state.next.append(State('$', len))
        }
    }

    head
  }

  def search(s: String, head: State): Boolean = {
    var idx = 0
    var tmp: ArrayBuffer[State] = ArrayBuffer(head)
    var notMatch = false
    while (idx < s.length && !notMatch) {
      //起点直接往前推
      tmp = moveHead(tmp)
      //判断当前state是否匹配
      val filtered = tmp.map {
        state =>
          state.c match {
            case '.' | '?' | '*' =>
              true -> state
            case _ =>
              (s(idx) == state.c) -> state
          }
      }.filter(_._1)
      //跳转state
      if (filtered.isEmpty) {
        notMatch = true
      } else {
        tmp = filtered.flatMap {
          case (_, state) =>
            //当前状态匹配后，只能往前推进
            val curr = state.idx
            state.next.filter(_.idx >= curr)
        }
      }
      idx += 1
    }
    if (notMatch) {
      false
    } else {
      tmp = moveHead(tmp)
      tmp.exists(_.c == '$')
    }
  }

  def moveHead(states: ArrayBuffer[State]) = {
    states.flatMap {
      s =>
        if (s.c == '^') {
          s.next
        } else {
          ArrayBuffer(s)
        }
    }.distinct
  }
}

object AsteriskStrategy extends Strategy {
  /**
    * 匹配规则
    * last-->.--->next
    * |     |^     ^
    * |            |
    * |------------|
    */
  override def plan(lastState: ArrayBuffer[State], regex: String, loc: Int): (ArrayBuffer[State], Int) = {

    //到上上个节点
    val len = regex.length
    val curr = State('*', loc)

    var hop: Int = 1
    //skip same *
    while (loc + hop < len && regex(loc + hop) == '*') hop += 1
    val skip = if (loc + hop < len) {
      State(regex(loc + hop), loc + 1)
    } else {
      State('$', len)
    }
    //last--->.
    lastState.foreach(_.next.append(curr))
    curr.last.appendAll(lastState)
    //.--->.
    curr.next.append(curr)
    curr.last.append(curr)
    //.--->skip
    curr.next.append(skip)
    skip.last.append(curr)
    //last--->skip
    lastState.foreach(_.next.append(skip))
    skip.last.appendAll(lastState)

    //move pointer
    ArrayBuffer(skip) -> (hop + 1)
  }
}

object DefaultStrategy extends Strategy {
  /**
    * 匹配规则
    * last-->curr
    */
  override def plan(lastState: ArrayBuffer[State], regex: String, loc: Int): (ArrayBuffer[State], Int) = {
    val s = State(regex(loc), loc)
    lastState.foreach(_.next.append(s))
    s.last = lastState
    ArrayBuffer(s) -> 1
  }
}

trait Strategy {

  /**
    * 匹配规则
    *
    * @param lastState
    * @param regex
    */
  def plan(lastState: ArrayBuffer[State], regex: String, loc: Int): (ArrayBuffer[State], Int)
}

case class State(
  c: Char,
  idx: Int,
  var next: ArrayBuffer[State] = ArrayBuffer.empty[State],
  var last: ArrayBuffer[State] = ArrayBuffer.empty[State]) {
  override def toString: String = c.toString

  override def equals(obj: Any): Boolean = {
    val other = obj.asInstanceOf[State]
    this.c == other.c && this.idx == other.idx
  }

  override def hashCode(): Int = {
    c.hashCode() + idx.hashCode()
  }
}
