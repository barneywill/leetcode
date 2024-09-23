import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber instance = new SingleNumber();
        System.out.println(instance.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(instance.singleNumber(new int[]{1}));
    }
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.toArray(new Integer[]{})[0];
    }
}
