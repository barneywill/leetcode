public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray instance = new MaximumSubarray();
        System.out.println(instance.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(instance.maxSubArray(new int[]{1}));
        System.out.println(instance.maxSubArray(new int[]{-1}));
        System.out.println(instance.maxSubArray(new int[]{-2, -1}));
        System.out.println(instance.maxSubArray(new int[]{5,4,-1,7,8}));
    }
    public int maxSubArray(int[] nums) {
        int result = 0;
        int sum = 0;
        if (nums.length == 1) {
            result = nums[0];
        } else {
            int minSum = Integer.MAX_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (minSum > sum) {
                    minSum = sum;
                }
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
            result = minSum > 0 ? maxSum : maxSum - minSum;
        }
        return result;
    }
}
