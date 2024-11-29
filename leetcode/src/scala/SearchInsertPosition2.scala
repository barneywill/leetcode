import scala.util.control.Breaks.{break, breakable}

object SearchInsertPosition2 {
  def main(args: Array[String]): Unit = {
    var nums = Array(1, 3, 5, 6)
    var target = 5
    println(searchInsert(nums, target))
  }
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var result = -1
    breakable {
      for (i <- nums.indices) {
        if (nums.apply(i) >= target) {
          result = i
          break
        }
      }
    }
    if (result == -1) nums.length else result
  }
}
