package category.math._300_400


/**
  * 365. Water and Jug Problem
  */
object _365_WaterAndJugProblem {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    if (z > x + y) return false
    
    def gcd(x: Int, y: Int): Int = {
      if (y == 0) x else gcd(y, x % y)
    }
    
    z == 0 || z % gcd(x, y) == 0
  }
  
  def canMeasureWaterV1(x: Int, y: Int, z: Int): Boolean = {
    /*all condition*/
    val capacity = new scala.collection.mutable.HashSet[Int]()
    capacity.add(x)
    capacity.add(y)
    var currentSize = capacity.size - 1
    while (currentSize != capacity.size) {
      currentSize = capacity.size
      capacity.toArray.foreach { inner =>
        capacity.add(Math.abs(inner - x))
        capacity.add(Math.abs(inner - y))
        if (inner <= y) capacity.add(inner + x)
        if (inner <= x) capacity.add(inner + y)
      }
    }
    
    if (z > (x + y)) return false
    if (z == x + y) return true
    if (capacity.contains(1)) return true
    capacity.remove(0)
    for (i <- 2 until z) {
      if (z % i == 0 && capacity.contains(i)) return true
    }
    false
    
  }
}