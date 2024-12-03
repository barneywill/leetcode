import scala.collection.mutable.ArrayBuffer

object PlusOne2 {
  def main(args: Array[String]): Unit = {
    val digits = Array(1, 2, 9)
    println(plusOne(digits).mkString(","))
  }
  def plusOne(digits: Array[Int]): Array[Int] = {
    val result = ArrayBuffer[Int]()
    var plus = 1
    Array.range(digits.length - 1, -1, -1).foreach(i => {
      var sum = digits.apply(i) + plus
      if (sum == 10) {
        result.insert(0, 0)
      } else {
        result.insert(0, sum)
        plus = 0
      }
    })
    if (plus == 1) result.insert(0, 1)
    result.toArray
  }
}
