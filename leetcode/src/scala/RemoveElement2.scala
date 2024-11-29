object RemoveElement2 {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 2, 2, 3)
    val v = 3
    println(removeElement(nums, v))
  }
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var lastIndex = 0
    for (i <- nums.indices) {
      if (nums.apply(i) != `val`) {
        nums.update(lastIndex, nums.apply(i))
        lastIndex += 1
      }
    }
    lastIndex
  }
}
