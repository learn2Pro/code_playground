package week27


/**
  * Created by Administrator on 2019/7/6 0006.
  */
object SortLinkedListSolution {
  def sortList(head: ListNode): ListNode = {
    if(head==null){
      head
    }else{
      var size: Int = 1
      var currTmpLast = new ListNode()
      currTmpLast.next = head
      val currHead = new ListNode()
      var currTmpHead = currHead
      var idx = 0
      var mergeTimes = 0
      //merge step by step until merge 2 sorted list
      while (mergeTimes != 1) {
        //one pass merge
        mergeTimes = 0
        //merge step by step
        while (getNodeNext(currTmpLast) != null) {
          var fast = getNodeNext(currTmpLast)
          var slow = getNodeNext(currTmpLast)
          //skip pointer for merge
          while (idx < size) {
            fast = getNodeNext(getNodeNext(fast))
            slow = getNodeNext(slow)
            idx += 1
          }
          val (first, last) = merge(getNodeNext(currTmpLast), slow, size)
          currTmpHead.next = first
          currTmpHead = last
          if (last != null) {
            last.next = fast
          }
          currTmpLast = last
          mergeTimes += 1
          idx = 0
        }
        //next round
        currTmpLast = new ListNode()
        currTmpLast.next = currHead.next
        currTmpHead = currHead
        size = size << 1
      }
      currHead.next
    }

  }

  def merge(p0: ListNode, p1: ListNode, size: Int): (ListNode, ListNode) = {
    if (p0 != null && p1 != null) {
      val head = new ListNode()
      var tmp = head
      var idx = 0
      var left = p0
      var right = p1
      var leftIdx = 0
      var rightIdx = 0
      while (idx < 2 * size) {
        if (tmp != null && rightIdx == size && leftIdx < size) {
          tmp.next = left
          leftIdx += 1
          left = getNodeNext(left)
        } else if (tmp != null && leftIdx == size && rightIdx < size) {
          tmp.next = right
          rightIdx += 1
          right = getNodeNext(right)
        } else if (tmp != null && leftIdx < size && rightIdx < size && getNodeValue(left) < getNodeValue(right)) {
          tmp.next = left
          leftIdx += 1
          left = getNodeNext(left)
        } else if (tmp != null && leftIdx < size && rightIdx < size && getNodeValue(left) >= getNodeValue(right)) {
          tmp.next = right
          rightIdx += 1
          right = getNodeNext(right)
        }
        tmp = getNodeNext(tmp)
        idx += 1
      }
      head.next -> tmp
    } else if (p0 == null && p1 != null) {
      var tmp = p1
      var idx = 0
      while (tmp != null && idx < size) {
        tmp = tmp.next
        idx += 1
      }
      p1 -> tmp
    } else if (p0 != null && p1 == null) {
      var tmp = p0
      var idx = 0
      while (tmp != null && idx < size) {
        tmp = tmp.next
        idx += 1
      }
      p0 -> tmp
    } else {
      throw new RuntimeException("not support both size is null")
    }

  }

  def getNodeValue(node: ListNode): Int = {
    if (node == null) {
      Int.MaxValue
    } else {
      node.x
    }
  }

  def getNodeNext(node: ListNode): ListNode = {
    if (node == null) {
      null
    } else {
      node.next
    }
  }

  def swap(last0: ListNode, last1: ListNode, p0: ListNode, p1: ListNode) = {
    val tmp = p0.next
    p0.next = p1.next
    p1.next = tmp
    if (last0 != null) {
      last0.next = p1
    }
    if (last1 != null) {
      last1.next = p0
    }
  }
}
