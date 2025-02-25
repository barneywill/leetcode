object ReverseWordsInAString {
    def reverseWords(s: String): String = {
        var result = ""
        val arr = s.split(" +")
        Array.range(arr.length - 1, -1, -1).foreach { i => if (arr(i).nonEmpty) result += " " + arr(i)}
        result = result.substring(1)
        result
    }

    def main(args: Array[String]): Unit = {
        val s = "the sky is blue"
        println(reverseWords(s))
    }
}