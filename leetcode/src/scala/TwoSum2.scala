object TwoSum2 {
  def main(args : Array[String]) : Unit = {
    val nums = Array(2, 7, 11, 15)
    val target = 9
    println(twoSum(nums, target).mkString(","))
  }
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- 0 until nums.length - 1) {
      val num = target - nums.apply(i)
      for (j <- i + 1 until nums.length) {
        if (nums.apply(j) == num) return Array(i, j)
      }
    }
    null
  }
}