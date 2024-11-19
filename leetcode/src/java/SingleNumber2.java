import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(((nums.length - 1) / 3) + 1);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result = key;
                break;
            }
        }
        return result;
    }

}
