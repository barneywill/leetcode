import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            boolean isFound = set.contains(target -i);
            set.add(i);
            if (isFound) {
                break;
            }
        }
        for (int i = 0, n = nums.length; i < n - 1; i++) {
            if (set.contains(target - nums[i])) {
                result[0] = i;
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] == target - nums[i]) {
                        result[1] = j;
                        break;
                    }
                }
                if (result[1] != 0) {
                    break;
                }
            }
        }
        return result;
    }
}
