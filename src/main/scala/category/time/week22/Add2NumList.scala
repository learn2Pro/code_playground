package category.time.week22

/**
  * Definition for singly-linked list.
  *
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x   : Int      = _x
}

object Add2Num {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var left = l1
    var right = l2
    val head = new ListNode(0)
    var carryBit: Boolean = false
    var curr: Int = 0
    var currList: ListNode = head
    while (left != null || right != null) {
      //left and right
      if (left != null && right != null) {
        curr = left.x + right.x + (if (carryBit) 1 else 0)
        left = left.next
        right = right.next
      } else if (left != null && right == null) {
        curr = left.x + (if (carryBit) 1 else 0)
        left = left.next
      } else if (left == null && right != null) {
        curr = right.x + (if (carryBit) 1 else 0)
        right = right.next
      } else {
        throw new RuntimeException("when left is null,right is null is not reasonable!")
      }
      carryBit = false
      carryBit = curr >= 10
      currList.next = new ListNode(curr % 10)
      currList = currList.next
    }
    if (carryBit) {
      currList.next = new ListNode(1)
    }
    head.next
  }
}