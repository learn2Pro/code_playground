package category.time.week39


object SingleNumber {
  
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduce((a0,a1)=>a0^a1)
  }
}