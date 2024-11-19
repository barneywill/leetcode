import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray instance = new FindFirstAndLastPositionOfElementInSortedArray();
        print(instance.searchRange(new int[]{5,7,7,8,8,10}, 8));
        print(instance.searchRange(new int[]{5,7,7,8,8,10}, 6));
        print(instance.searchRange(new int[]{}, 0));
        print(instance.searchRange(new int[]{1}, 1));
    }
    private static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (nums.length > 0) {
            int index = Arrays.binarySearch(nums, target);
            if (index >= 0) {
                start = index;
                end = index;

                if (index > 0 && nums[index - 1] == target) {
                    int nextStart = findNext(nums, target, 0, index - 1, true);
                    if (nextStart != -1 && nextStart < start) {
                        start = nextStart;
                    }
                }
                if (index < nums.length - 1 && nums[index + 1] == target) {
                    int nextEnd = findNext(nums, target, index + 1,  nums.length - 1, false);
                    if (nextEnd != -1 && nextEnd > end) {
                        end = nextEnd;
                    }
                }
            }
        }
        return new int[]{start, end};
    }
    private int findNext(int[] nums, int target, int start, int end, boolean isBackward) {
        if (isBackward && nums[start] == target) {
            return start;
        } else if (!isBackward && nums[end] == target) {
            return end;
        }
        if (start + 1 == end) {
            if (isBackward) {
                return end;
            } else {
                return start;
            }
        }

        int middle = (start + end) / 2;
        if (isBackward) {
            if (nums[middle] == target) {
                return findNext(nums, target, start, middle, isBackward);
            } else {
                return findNext(nums, target, middle, end, isBackward);
            }
        } else {
            if (nums[middle] == target) {
                return findNext(nums, target, middle, end, isBackward);
            } else {
                return findNext(nums, target, start, middle, isBackward);
            }
        }
    }
}
