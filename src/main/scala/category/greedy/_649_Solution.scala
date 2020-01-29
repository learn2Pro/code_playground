package category.greedy

/**
  * 649. Dota2 Senate
  */
object _649_Solution {
  def predictPartyVictory(senate: String): String = {
    val rqueue, dqueue = new java.util.LinkedList[Int]
    val N = senate.length
    for (i <- senate.indices) {
      senate(i) match {
        case 'R' =>
          rqueue.add(i)
        case 'D' =>
          dqueue.add(i)
      }
    }
    while (!rqueue.isEmpty && !dqueue.isEmpty) {
      val r0 = rqueue.remove()
      val d0 = dqueue.remove()
      if (r0 < d0) rqueue.add(r0 + N)
      else dqueue.add(d0 + N)
    }
    if (rqueue.size() > dqueue.size()) "Radiant" else "Dire"
  }
  
  //  def predictPartyVictory(senate: String): String = {
  //    var RCnt, RVote, DCnt, DVote = 0
  //    var back = false
  //    senate.foreach {
  //      case 'R' =>
  //        if (DVote <= 0) {RCnt += 1; RVote += 1; back = false} else {DVote -= 1;}
  //      case 'D' =>
  //        if (RVote <= 0) {DCnt += 1; DVote += 1; back = true} else {RVote -= 1;}
  //    }
  //    DCnt -= RVote
  //    RCnt -= DVote
  //    while (DCnt != 0 && RCnt != 0) {
  //      if (back) {DCnt = Math.max(0, DCnt - RCnt); back = !back}
  //      else {RCnt = Math.max(0, RCnt - DCnt); back = !back}
  //    }
  //    if (RCnt > 0) "Radiant" else "Dire"
  //  }
}