package category.dp._1000

/**
  * 1227. Airplane Seat Assignment Probability
  */
object _1227_AirplaneSeatAssignmentProb {
  def nthPersonGetsNthSeat(n: Int): Double = {
    if (n == 1) 1.0
    else 0.5
  }
}