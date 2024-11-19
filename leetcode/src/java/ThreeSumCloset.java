import java.util.Arrays;

public class ThreeSumCloset {
    public static void main(String[] args) {
        ThreeSumCloset instance = new ThreeSumCloset();
        System.out.println(instance.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(instance.threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(instance.threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (target >= 0 && nums[i] - target >= diff) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (target >= 0 && nums[i] + nums[j] - target >= diff) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (target >= 0 && nums[i] + nums[j] + nums[k] - target >= diff) {
                        break;
                    } else if (diff > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        result = nums[i] + nums[j] + nums[k];
                        diff = Math.abs(result - target);
                    }
                }
            }
        }
        return result;
    }
}
