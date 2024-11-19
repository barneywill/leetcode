import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(instance.search(new int[]{1}, 0));
        System.out.println(instance.search(new int[]{1,3,5}, 2));
        //[4,5,6,7,8,1,2,3]
        //2
        System.out.println(instance.search(new int[]{4,5,6,7,8,1,2,3}, 2));
    }
    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            return trim(Arrays.binarySearch(nums, target));
        } else {
            return search(nums, 0, nums.length - 1, target);
        }
    }
    private int trim(int index) {
        return index < 0 ? -1 : index;
    }
    private int search(int[] nums, int start, int end, int target) {
//        System.out.println("search : " + start + ", " + end + ", " + target);
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else if (start == end || start + 1 == end) {
            return -1;
        } else {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[start] < nums[middle]) {
                if (target > nums[start] && target < nums[middle]) {
                    return trim(Arrays.binarySearch(nums, start, middle, target));
                }
                else {
                    return search(nums, middle, end, target);
                }
            } else if (nums[middle] < nums[end]) {
                if (target > nums[middle] && target < nums[end]) {
                    return trim(Arrays.binarySearch(nums, middle, end, target));
                } else {
                    return search(nums, start, middle, target);
                }
            } else {
                return -1;
            }
        }
    }
}
