public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement instance = new RemoveElement();
        System.out.println(instance.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(instance.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
    public int removeElement(int[] nums, int val) {
        int result = 0;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    result++;
                    if (result - 1 != i) {
                        nums[result - 1] = nums[i];
                    }
                }
            }
        }
        return result;
    }
}
