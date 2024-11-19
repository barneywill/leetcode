import java.util.Arrays;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII instance = new SearchInRotatedSortedArrayII();
        System.out.println(instance.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(instance.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(instance.search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}, 13));

    }
    public boolean search(int[] nums, int target) {
        return searchByRange(nums, 0, nums.length - 1, target);
    }
    private boolean searchByRange(int[] nums, int start, int end, int target) {
//        System.out.println("searchByRange : " + start + ", " + end);
        if (nums[start] == target || nums[end] == target) {
            return true;
        } else if (start == end || start + 1 == end) {
            return false;
        } else if (nums[start] < nums[end]) {
            if (target < nums[start] || target > nums[end]) {
                return false;
            } else {
                return Arrays.binarySearch(nums, start, end + 1, target) >= 0;
            }
        } else {
            int middle = (start + end) / 2;
//            System.out.println("middle : " + middle + ", " + nums[middle]);
            if (target == nums[middle]) {
                return true;
            } else if (nums[start] < nums[middle]) {
                if (target > nums[start] && target < nums[middle]) {
                    return Arrays.binarySearch(nums, start, middle, target) >= 0;
                } else {
                    return searchByRange(nums, middle + 1, end, target);
                }
            } else if (nums[middle] < nums[end]) {
                if (target > nums[middle] && target < nums[end]) {
                    return Arrays.binarySearch(nums, middle + 1, end + 1, target) >= 0;
                } else {
                    return searchByRange(nums, start, middle - 1, target);
                }
            } else {
                return searchByRange(nums, start, middle - 1, target) || searchByRange(nums, middle + 1, end, target);
            }
        }
    }
}
