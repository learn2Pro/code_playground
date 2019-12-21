package category.math._300_400

/**
  * 335. Self Crossing
  */
object _335_SelfCrossing {
  def isSelfCrossing(x: Array[Int]): Boolean = {
    for (i <- 3 until x.length) {
      /**
        * first condition
        * |-------|
        * |       |
        * |------->|
        * |
        */
      if (x(i) >= x(i - 2) && x(i - 1) <= x(i - 3)) {
        return true
      }
      
      /**
        * second condition
        * |-------|
        * |       |
        * |       |
        * |------->
        */
      if (i >= 4 && x(i - 1) == x(i - 3) && x(i) >= (x(i - 2) - x(i - 4))) {
        return true
      }
      
      /**
        * x(1)
        * ┌──────┐
        * │      │x(0)
        * x(2)   │<│────│
        * │       x(5)│x(4)
        * └───────────│
        * x(3)
        */
      if (i >= 5 && x(i - 2) >= x(i - 4) && x(i - 3) >= x(i - 1) && x(i - 1) >= x(i - 3) - x(i - 5) && x(i) >= x(i - 2) - x(i - 4)) {
        return true
      }
    }
    false
    
  }
}