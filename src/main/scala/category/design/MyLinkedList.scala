package category.design

/**
  * 707. Design Linked List
  *
  * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
  * [[],[1],[3],[1,2],[1],[1],[1]]
  * ["MyLinkedList","addAtHead","deleteAtIndex"]
  * [[],[1],[0]]
  * ["MyLinkedList","addAtHead","addAtHead","deleteAtIndex"]
  * [[],[1],[2],[1]]
  * ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
  * [[],[0,10],[0,20],[1,30],[0]]
  * ["MyLinkedList","addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"]
  * [[],[84],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]]
  */
case class Node(entity: Integer, var next: Node = null, var pre: Node = null)

class MyLinkedList() {
  
  /** Initialize your data structure here. */
  var size        = 0
  var first: Node = _
  var last : Node = _
  
  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    /*range check*/
    if (index < 0 || index >= size) return -1
    var p = 0
    var tmp = first
    while (p < index) {tmp = tmp.next; p += 1}
    tmp.entity
  }
  
  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int): Unit = {
    val curr = Node(`val`)
    if (size == 0) {this.first = curr; this.last = curr}
    else {
      curr.next = first
      first.pre = curr
      this.first = curr
    }
    this.size += 1
  }
  
  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int): Unit = {
    val curr = Node(`val`)
    if (size == 0) {this.first = curr; this.last = curr}
    else {
      curr.pre = last
      last.next = curr
      this.last = curr
    }
    this.size += 1
  }
  
  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int) {
    if (index > size) return
    if (index == size) addAtTail(`val`)
    else if (index == 0) addAtHead(`val`)
    else {
      val curr = Node(`val`)
      var p = 0
      var tmp = first
      while (p < index) {tmp = tmp.next; p += 1}
      curr.next = tmp
      curr.pre = tmp.pre
      tmp.pre.next = curr
      tmp.pre = curr
      size += 1
    }
  }
  
  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int) {
    if (index >= size || index < 0) return
    if (index == 0) {
      if (size == 1) {this.first = null; this.last = null}
      else {
        val tmp = first.next
        first.next = null
        this.first = tmp
        tmp.pre = null
      }
    } else if (index == size - 1) {
      val tmp = last.pre
      last.pre = null
      tmp.next = null
      this.last = tmp
    } else {
      var p = 0
      var tmp = first
      while (p < index) {tmp = tmp.next; p += 1}
      val pre = tmp.pre
      val next = tmp.next
      tmp.pre = null
      tmp.next = null
      pre.next = next
      next.pre = pre
    }
    size -= 1
  }
  
}