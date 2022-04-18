import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum instance = new FourSum();
        System.out.println(instance.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(instance.fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(instance.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length > 3) {
            Integer[] numsArray = shrink(nums);
            int n = numsArray.length;
            Set<String> set = new HashSet<String>();
            int min = numsArray[0];
            int max = numsArray[n - 1];
            for (int i = 0; i < n - 3; i++) {
                if (isBreak(numsArray[i], target)) {
                    break;
                }
                for (int j = i + 1; j < n - 2; j++) {
                    if (isBreak(numsArray[i] + numsArray[j], target)) {
                        break;
                    }
                    for (int k = j + 1; k < n - 1; k++) {
                        if (isBreak(numsArray[i] + numsArray[j] + numsArray[k], target)) {
                            break;
                        }
                        for (int l = k + 1; l < n; l++) {
                            int fourSum = numsArray[i] + numsArray[j] + numsArray[k] + numsArray[l];
                            if (fourSum == target) {
                                if (!set.contains("" + numsArray[i] + numsArray[j] + numsArray[k])) {
                                    result.add(Arrays.asList(numsArray[i], numsArray[j], numsArray[k], numsArray[l]));
                                    set.add("" + numsArray[i] + numsArray[j] + numsArray[k]);
                                }
                                break;
                            }
                            if (isBreak(fourSum, target)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isBreak(int sum, int target) {
        return (target > 0 && sum > target) || (target <= 0 && sum > 0);
    }
    private Integer[] shrink(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i <= 3) {
                result.add(nums[i]);
            } else {
                if (nums[i] != result.get(result.size() - 4)) {
                    result.add(nums[i]);
                }
            }
        }
        return result.toArray(new Integer[0]);
    }
}
