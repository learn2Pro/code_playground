package week26

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/06/30
  */
object RegExpSolution {
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
      p(idx) match {
        case '*' =>

          /**
            * last---->curr---->skip
            * ^        |^       ^
            * |        ||       |
            * |--------         |
            * |                 |
            * |-----------------
            **/
          //到上上个节点
          last.foreach(_.next.appendAll(last.flatMap(_.last)))
          //自己的cycle
          last.foreach(_.next.appendAll(last))
          val skip = if (idx + 1 < len) {
            State(p(idx + 1), idx + 1)
          } else {
            State('$', len)
          }
          last.foreach(_.next.append(skip))
          last.flatMap(_.last).foreach(_.next.append(skip))
          skip.last = last ++ last.flatMap(_.last)
          last = ArrayBuffer(skip)
          idx += 1
        case _ =>
          val s = State(p(idx), idx)
          last.foreach(_.next.append(s))
          s.last = last
          last = ArrayBuffer(s)
      }
      idx += 1
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
            case '.' =>
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

case class State(c: Char,
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
