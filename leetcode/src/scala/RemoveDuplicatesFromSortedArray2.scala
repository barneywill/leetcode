object RemoveDuplicatesFromSortedArray2 {
  def main(args : Array[String]) : Unit = {
    val nums = Array(1, 1, 2)
    println(removeDuplicates(nums))
  }
  def removeDuplicates(nums: Array[Int]): Int = {
    var result = 0
    var lastNum = 0
    var lastIndex = -1
    for (i <- nums.indices) {
      if (lastIndex == -1) {
        lastNum = nums.apply(i)
        lastIndex = i
        result += 1
      } else {
        if (lastNum != nums.apply(i)) {
          lastNum = nums.apply(i)
          lastIndex += 1
          nums.update(lastIndex, lastNum)
          result += 1
        }
      }
    }
    result
  }
}
