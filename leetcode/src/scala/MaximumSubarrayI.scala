object MaximumSubarrayI {
    def findMaxAverage(nums: Array[Int], k: Int): Double = {
        var maxSum = 0.0
        var currentSum = 0.0
        Array.range(0, nums.length).foreach(i => {
            if (i < k) {
                currentSum += nums(i)
                maxSum = currentSum
            } else {
                currentSum -= nums(i - k)
                currentSum += nums(i)
                if (currentSum > maxSum) maxSum = currentSum
            }
        })
        maxSum / k
    }
}