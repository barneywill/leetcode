import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(instance.numTrees(1));
        System.out.println(instance.numTrees(2));
        System.out.println(instance.numTrees(3));
        System.out.println(instance.numTrees(4));
    }
    private Map<Integer, Integer> possibilitiesMap = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        int result = 0;
        if (possibilitiesMap.containsKey(n)) {
            result = possibilitiesMap.get(n);
        } else {
            if (n == 0 || n == 1) {
                result = 1;
            } else if (n == 2) {
                result = 2;
            } else {
                for (int i = 0; i < n; i++) {
                    int left = numTrees(i);
                    int right = numTrees(n - i - 1);
                    result += left * right;
                }
            }
            possibilitiesMap.put(n, result);
        }
        return result;
    }
}
