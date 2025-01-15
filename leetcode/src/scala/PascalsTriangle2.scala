object PascalsTriangle2 {
    def generate(numRows: Int): List[List[Int]] = {
        var result = List(List(1))
        if (numRows >= 2) result = result :+ List(1, 1)
        if (numRows > 2) {
            var last = List(1, 1)
            Array.range(2, numRows).foreach(i => {
                val current = (Array(1) ++ Array.range(0, last.length - 1).collect({case j: Int => last.apply(j) + last.apply(j + 1)}) ++ Array(1)).toList
                result = result :+ current
                last = current
            })
        }
        result
    }
}