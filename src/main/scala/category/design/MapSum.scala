package category.design

/**
  * 677. Map Sum Pairs
  *
  * ["MapSum", "insert", "sum", "insert", "sum"]
  * [[], ["apple",3], ["ap"], ["app",2], ["ap"]]
  * ["MapSum", "insert","insert", "sum", "insert", "sum"]
  * [[], ["apple",3],["apple",4], ["ap"], ["app",2], ["ap"]]
  */
class MapSum() {
  
  /** Initialize your data structure here. */
  var num: Int = 0
  val children = new Array[MapSum](256)
  
  def insert(key: String, `val`: Int): Unit = {
    var curr = this
    key.foreach { c =>
      if (curr.children(c) == null) curr.children(c) = new MapSum
      curr = curr.children(c)
    }
    curr.num = `val`
  }
  
  def sum(prefix: String): Int = {
    var curr = this
    prefix.foreach { c =>
      curr = curr.children(c)
      if (curr == null) return 0
    }
    iterate(curr)
  }
  
  def iterate(node: MapSum): Int = {
    if (node == null) return 0
    node.num + node.children.map(iterate).sum
  }
  
}