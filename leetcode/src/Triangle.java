import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle instance = new Triangle();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(instance.minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer result = null;
        if (triangle.size() > 1) {
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    Integer left = null;
                    if (j - 1 >= 0) {
                        left = triangle.get(i - 1).get(j - 1);
                    }
                    Integer right = null;
                    if (j != triangle.get(i).size() - 1) {
                        right = triangle.get(i - 1).get(j);
                    }
                    int min = left == null ? right : right == null ? left : Math.min(left, right);
                    triangle.get(i).set(j, min + triangle.get(i).get(j));
                }
            }
        }
        for (Integer sum : triangle.get(triangle.size() - 1)) {
            if (result == null) {
                result = sum;
            } else if (sum < result) {
                result = sum;
            }
        }
        return result;
    }
}
