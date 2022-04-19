public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        System.out.println(instance.removeDuplicates(new int[]{1,1,2}));
        System.out.println(instance.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    public int removeDuplicates(int[] nums) {
        int result = 1;
        if (nums.length > 1) {
            for (int i = 1, n = nums.length; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    result++;
                    nums[result - 1] = nums[i];
                }
            }
        }
        return result;
    }
}
