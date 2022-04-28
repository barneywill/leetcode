public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII instance = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(instance.removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(instance.removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        } else {
            int currentNum = 0;
            int currentIndex = 0;
            int currentCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    currentNum = nums[i];
                    currentIndex = 0;
                    currentCount = 1;
                } else {
                    if (nums[i] == currentNum) {
                        currentCount++;
                        if (currentCount <= 2) {
                            nums[++currentIndex] = nums[i];
                        }
                    } else {
                        currentNum = nums[i];
                        currentCount = 1;
                        nums[++currentIndex] = nums[i];
                    }
                }
            }
            return currentIndex + 1;
        }
    }
}
