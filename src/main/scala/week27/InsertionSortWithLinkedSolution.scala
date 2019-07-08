package week27

/**
  * Created by Administrator on 2019/7/7 0007.
  */
object InsertionSortWithLinkedSolution {
  def insertionSortList(head: ListNode): ListNode = {
    var sorted: ListNode = null
    var curr = head
    while (curr != null) {
      sorted = insert(new ListNode(curr.x), sorted)
      curr = curr.next
    }
    sorted
  }

  def insert(node2Insert: ListNode, head: ListNode): ListNode = {
    if (head == null) {
      node2Insert
    } else {
      var arr = head
      var last = head
      var idx = 0
      while (arr != null && arr.x < node2Insert.x) {
        last = arr
        arr = arr.next
        idx += 1
      }
      if (idx > 0) {
        last.next = node2Insert
        node2Insert.next = arr
        head
      } else {
        node2Insert.next = arr
        node2Insert
      }
    }
  }
}
