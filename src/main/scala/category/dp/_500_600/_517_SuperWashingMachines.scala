package category.dp._500_600

/**
  * 517. Super Washing Machines
  */
object _517_SuperWashingMachines {
  def findMinMoves(machines: Array[Int]): Int = {
    val sum = machines.sum
    if (sum % machines.length != 0) return -1
    val target = sum / machines.length
    var ans, offset = 0
    for (dress <- machines) {
      offset = offset + dress - target
      ans = Math.max(ans, Math.max(Math.abs(offset), dress - target))
    }
    ans
  }
}