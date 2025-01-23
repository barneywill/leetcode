object KidsWithTheGreatestNumberOfCandies2 {
    def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
        val max = candies.max
        candies.collect({case i: Int => i + extraCandies >= max}).toList
    }
}