import sun.jvm.hotspot.utilities.BitMap;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive instance = new FirstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(instance.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(instance.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
    public int firstMissingPositive(int[] nums) {
        int nonePositiveCount = 0;
        int minPositive = Integer.MAX_VALUE;
        int maxPositive = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                nonePositiveCount++;
            } else {
                if (minPositive > num) {
                    minPositive = num;
                }
                if (num > maxPositive) {
                    maxPositive = num;
                }
            }
        }
        if (nonePositiveCount == nums.length || minPositive > 1) {
            return 1;
        } else {
            int length = Math.min(nums.length - nonePositiveCount, maxPositive);
            byte[] bm = new byte[length];
            for (int num : nums) {
                if (num > 0 && num <= length) {
                    bm[num - 1] = 1;
                }
            }
            for (int i = 0; i < length; i++) {
                if (bm[i] == 0) {
                    return i + 1;
                }
            }
            return length + 1;
        }
    }
}
