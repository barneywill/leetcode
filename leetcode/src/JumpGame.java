public class JumpGame {
    public static void main(String[] args) {
        JumpGame instance = new JumpGame();
        System.out.println(instance.canJump(new int[]{2,3,1,1,4}));
        System.out.println(instance.canJump(new int[]{3,2,1,0,4}));
    }
    public boolean canJump(int[] nums) {
        boolean result = false;
        if (nums.length == 1) {
            result = true;
        } else if (nums.length == 2) {
            if (nums[0] != 0) {
                result = true;
            }
        } else if (nums[0] >= nums.length - 1) {
            result = true;
        } else {
            int[] valid = new int[nums.length];
            valid[valid.length - 1] = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (valid[i] > 0) {
                    for (int j = nums.length - 2; j >= 0; j--) {
                        if (nums[j] + j >= i) {
                            valid[j] = 1;
                        }
                    }
                    if (valid[0] == 1) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
