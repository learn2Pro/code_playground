package week27

/**
  * Created by Administrator on 2019/7/6 0006.
  */


class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object MergeSortedListSolution {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    var tmp = lists
    while (tmp.length > 1) {
      tmp  = tmp.grouped(2).map {
        arr =>
          if (arr.length == 2) {
            mergeList(arr)
          } else {
            arr.head
          }
      }.toArray
    }
    if(tmp.isEmpty){
      null
    }else{
      tmp.head
    }
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    mergeList(Array(l1, l2))
  }

  def mergeList(lists: Array[ListNode]): ListNode = {
    val head = new ListNode
    var tmp = head
    while (lists.exists(_ != null)) {
      tmp.next = chooseAndMoveMin(lists)
      tmp = tmp.next
    }
    head.next
  }

  def chooseAndMoveMin(lists: Array[ListNode]): ListNode = {
    val minNode = lists.zipWithIndex.filter(_._1 != null).minBy(_._1.x)
    //move
    if (lists(minNode._2) != null) {
      lists(minNode._2) = lists(minNode._2).next
    }
    minNode._1.next = null
    minNode._1
  }

}
