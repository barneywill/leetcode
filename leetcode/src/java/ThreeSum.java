import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        System.out.println(instance.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(instance.threeSum(new int[]{}));
        System.out.println(instance.threeSum(new int[]{0}));
        System.out.println(instance.threeSum(new int[]{0,0,0,0,0,0,0,-1,0,0,0,0,0,1}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n >= 3) {
            Integer[] numsArray = shrink(nums);
            System.out.println(numsArray.length);
            n = numsArray.length;
            if (n >= 3) {
                int min = numsArray[0];
                int max = numsArray[n - 1];
                if ((min == 0 && max == 0) || (min == 0 && numsArray[2] == 0) || (max == 0 && numsArray[n - 3] == 0)) {
                    result.add(Arrays.asList(0, 0, 0));
                } else if (min < 0 && max > 0) {
                    for (int i = 0; i < n - 2; i++) {
                        if (numsArray[i] > 0) {
                            break;
                        }
                        if (i > 0 && numsArray[i].equals(numsArray[i - 1])) {
                            continue;
                        }
                        for (int j = i + 1; j < n - 1; j++) {
                            if (j > i + 1 && numsArray[j].equals(numsArray[j - 1])) {
                                continue;
                            }
                            int sum = numsArray[i] + numsArray[j];
                            if (sum > 0) {
                                break;
                            } else if (sum < 0 && Math.abs(sum) > max) {
                                continue;
                            } else {
                                for (int k = n - 1; k > j; k--) {
                                    if (numsArray[k] == sum * -1) {
                                        result.add(Arrays.asList(numsArray[i], numsArray[j], numsArray[k]));
                                        break;
                                    } else if (numsArray[k] < 0) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    private Integer[] shrink(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i <= 2) {
                result.add(nums[i]);
            } else if (!result.get(result.size() - 3).equals(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result.toArray(new Integer[0]);
    }
}
