package category.math._400_500


/**
  * 478. Generate Random Point in a Circle
  *
  * @param _radius
  * @param _x_center
  * @param _y_center
  */
class _478_GenRanPointInCircle(_radius: Double, _x_center: Double, _y_center: Double) {
  
  def randPoint(): Array[Double] = {
    val dis = Math.random() * _radius
    val deg = Math.random() * 2 * Math.PI
    val xLocation = _x_center + dis * Math.cos(deg)
    val yLocation = _y_center + dis * Math.sin(deg)
    Array(xLocation, yLocation)
  }
  
}