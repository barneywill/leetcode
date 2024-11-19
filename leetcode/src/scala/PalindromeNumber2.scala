object PalindromeNumber2 {
  def main(args: Array[String]): Unit = {
    val x = 121
    println(isPalindrome(x))
  }
  def isPalindrome(x: Int): Boolean = {
    val str : String = x.toString()
    for (i <- 0 until str.length) {
      var j = str.length - 1 - i
      if (i <= j && str.apply(i) != str.apply(j)) {
        return false
      }
    }
    true
  }
}
