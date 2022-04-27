public class SortColors {
    public static void main(String[] args) {
        SortColors instance = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        instance.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < counts[0]) {
                nums[i] = 0;
            } else if (i < counts[0] + counts[1]) {
                nums[i] = 1;
            } else {
                nums[i]= 2;
            }
        }
    }
}
