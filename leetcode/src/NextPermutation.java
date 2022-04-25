public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation instance = new NextPermutation();
        int[] nums = new int[]{1,2,3};
        instance.nextPermutation(nums);
        print(nums);
        nums = new int[]{3,2,1};
        instance.nextPermutation(nums);
        print(nums);
        nums = new int[]{1,1,5};
        instance.nextPermutation(nums);
        print(nums);
    }
    private static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    public void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            int min = 101;
            int max = -1;
            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (min > nums[i]) {
                    min = nums[i];
                }
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            if (min < max) {
                if (min == nums[0]) {
                    int tmp = nums[maxIndex];
                    nums[maxIndex] = nums[maxIndex - 1];
                    nums[maxIndex - 1] = tmp;
                } else {
                    int nextMax = -1;
                    int nextMaxIndex = 0;
                    for (int i = 1; i < nums.length; i++) {
                        if (nums[i] < nums[0]) {
                            if (nextMax < nums[i]) {
                                nextMax = nums[i];
                                nextMaxIndex = i;
                            }
                        }
                    }
                    int tmp = nums[nextMaxIndex];
                    nums[nextMaxIndex] = nums[nextMaxIndex - 1];
                    nums[nextMaxIndex - 1] = tmp;
                }
                boolean isOk = false;
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] < nums[i + 1]) {
                        isOk = true;
                        break;
                    }
                }
                if (!isOk) {
                    nextPermutation(nums);
                }
            }
        }

    }
}
