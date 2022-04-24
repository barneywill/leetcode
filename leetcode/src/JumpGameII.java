public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII instance = new JumpGameII();
        System.out.println(instance.jump(new int[]{2}));
        System.out.println(instance.jump(new int[]{2,3,1}));
        System.out.println(instance.jump(new int[]{2,3,1,1,4}));
        System.out.println(instance.jump(new int[]{2,3,0,1,4}));
        System.out.println(instance.jump(new int[]{2,3,0,1,1,4}));
    }
    public int jump(int[] nums) {
        int result = 0;
        if (nums.length == 1) {
            return result;
        } else if (nums[0] >= nums.length - 1) {
            return ++result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (i + nums[i] >= nums.length - 1) {
                    return ++result;
                }
                int max = 0;
                int maxIndex = 0;
                for (int j = 1; j <= Math.min(nums[i], nums.length - 1 - i); j++) {
                    if (i + j + nums[i + j] >= nums.length - 1) {
                        return result + 2;
                    } else {
                        if (i + j + nums[i + j] > max) {
                            max = i + j + nums[i + j];
                            maxIndex = i + j;
                        }
                    }
                }
                i = maxIndex - 1;
                result++;
            }
        }
        return result;
    }
}
