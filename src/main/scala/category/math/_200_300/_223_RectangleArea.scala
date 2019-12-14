package category.math._200_300

/**
  * 223. Rectangle Area
  */
object _223_RectangleArea {
  def computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int = {
    def area(lb: (Int, Int), ru: (Int, Int)): Int = {
      (ru._2 - lb._2) * (ru._1 - lb._1)
    }
    
    val crossLB_x = Math.max(A, E)
    val crossLB_y = Math.max(B, F)
    val crossUR_x = Math.min(C, G)
    val crossUR_y = Math.min(D, H)
    val xM = Math.abs((C - A) / 2 + (G - E) / 2) > Math.abs((C + A) / 2 - (G + E) / 2)
    val yM = Math.abs((D - B) / 2 + (H - F) / 2) > Math.abs((D + B) / 2 - (H + F) / 2)
    val crossArea = if (xM && yM) area((crossLB_x, crossLB_y), (crossUR_x, crossUR_y)) else 0
    area((A, B), (C, D)) + area((E, F), (G, H)) - crossArea
  }
}