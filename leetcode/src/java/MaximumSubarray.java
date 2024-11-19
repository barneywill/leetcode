public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray instance = new MaximumSubarray();
        System.out.println(instance.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(instance.maxSubArray(new int[]{1}));
        System.out.println(instance.maxSubArray(new int[]{-1}));
        System.out.println(instance.maxSubArray(new int[]{-2, -1}));
        System.out.println(instance.maxSubArray(new int[]{-1, -2}));
        System.out.println(instance.maxSubArray(new int[]{-1, 0, -2}));
        System.out.println(instance.maxSubArray(new int[]{0, -3, 1, 1}));
        System.out.println(instance.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(instance.maxSubArray(new int[]{9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8}));
    }
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        if (nums.length == 1) {
            result = nums[0];
        } else {
            int minSum = Integer.MAX_VALUE;
            int minSumIndex = 0;
            int maxSum = Integer.MIN_VALUE;
            int maxSumIndex = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
                if (min > nums[i]) {
                    min = nums[i];
                }
                if (max < nums[i]) {
                    max = nums[i];
                }
                if (minSum > sum) {
                    minSum = sum;
                    minSumIndex = i;
                }
                if (maxSum < sum) {
                    maxSum = sum;
                    maxSumIndex = i;
                }
            }
//            System.out.println("" + minSum + ", " + minSumIndex + ", " + maxSum + ", " + maxSumIndex);
            if (max <= 0) {
                result = max;
            } else if (minSum > 0) {
                result = maxSum;
            } else if (minSumIndex < maxSumIndex) {
                result = maxSum - minSum;
            } else {
                result = Math.max(maxSum, max);
                int currentMin = Integer.MAX_VALUE;
                for (int i = 0; i < sums.length - 1; i++) {
                    if (sums[i] < 0 && sums[i] < currentMin) {
                        currentMin = sums[i];
                        for (int j = i + 1; j < sums.length; j++) {
                            if (sums[j] > sums[i] && result < sums[j] - sums[i]) {
                                result = sums[j] - sums[i];
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
