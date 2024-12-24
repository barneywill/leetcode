object MergeSortedArray2 {
    def merge(nums1: Array(Int), m: Int, nums2: Array(Int), n: Int): Unit = {
        var index1 = m
        var index2 = n
        while (index1 + index2 > 0) {
            if (index1 == 0) {
                for (i <- 0 until index2) {
                    nums1(i) = nums2(i)
                }
                return
            } else if (index2 == 0) {
                return
            } else if (nums1(index1 - 1) < nums2(index2 - 1)) {
                nums1(index1 + index2 - 1) = nums2(index2 - 1)
                index2 = index2 - 1
            } else {
                nums1(index1 + index2 - 1) = nums1(index1 - 1)
                index1 = index1 - 1
            }
        }
    }
}