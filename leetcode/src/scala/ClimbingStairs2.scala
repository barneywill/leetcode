object ClimbingStairs2 {
  def main(args: Array[String]): Unit = {
    val n = 3
    println(climbStairs(n))
  }
  def climbStairs(n: Int): Int = {
    var result = 0
    if (n == 1) result = 1
    else if (n == 2) result = 2
    else {
      var last1 = 1
      var last2 = 2
      for (i <- 0 until n - 2) {
        result = last1 + last2
        last1 = last2
        last2 = result
      }
    }
    result
  }
}
