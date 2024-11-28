import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

object ValidParentheses2 {
  def main(args : Array[String]) : Unit = {
    var s = "([]"
    println(isValid(s))
  }
  def isValid(s: String): Boolean = {
    var result = true
    var arr : ArrayBuffer[Char] = ArrayBuffer()
    breakable {
      for (i <- 0 until s.length) {
        if (arr.isEmpty) arr.append(s.charAt(i))
        else {
          if (isStart(arr.last) && isStart(s.charAt(i))) arr.append(s.charAt(i))
          else if (isMatch(arr.last, s.charAt(i))) arr.remove(arr.length - 1)
          else {result = false; break}
        }
      }
    }
    result && arr.isEmpty
  }
  def isStart(c : Char) : Boolean = c == '(' || c == '[' || c == '{'
  def isMatch(c1 : Char, c2 : Char) = (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')
}
