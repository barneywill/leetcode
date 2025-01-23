import scala.collection.mutable.ArrayBuffer

object ReverseVowelsOfAString2 {
    def reverseVowels(s: String): String = {
        var result = ""
        val arr = ArrayBuffer[Char]()
        Array.range(0, s.length).foreach(i => if (isVowels(s.charAt(i))) arr.append(s.charAt(i)))
        Array.range(0, s.length).foreach(i => {
            result += (if (isVowels(s.charAt(i))) arr.remove(arr.length - 1) else s.charAt(i)).toString
        })
        result
    }
    val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    def isVowels(c: Char): Boolean = vowels(c)
}