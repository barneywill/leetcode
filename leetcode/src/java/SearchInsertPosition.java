public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition instance = new SearchInsertPosition();
        System.out.println(instance.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(instance.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(instance.searchInsert(new int[]{1,3,5,6}, 7));
    }
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        } else if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        } else {
            return search(nums, target, 0, nums.length - 1);
        }
    }
    private int search(int[] nums, int target, int start, int end) {
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else if (start == end) {
            if (target > nums[start]) {
                return start + 1;
            } else {
                return start - 1;
            }
        } else if (start + 1 == end) {
            if (target < nums[start]) {
                return start - 1;
            } else if (target < nums[end]) {
                return end;
            } else {
                return end + 1;
            }
        } else {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                return search(nums, target, start, middle);
            } else {
                return search(nums, target, middle, end);
            }
        }
    }
}
