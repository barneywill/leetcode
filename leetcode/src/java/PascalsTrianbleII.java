import java.util.ArrayList;
import java.util.List;

public class PascalsTrianbleII {
    public static void main(String[] args) {
        PascalsTrianbleII instance = new PascalsTrianbleII();
        System.out.println(instance.getRow(5));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
            } else {
                list.add(result.get(0));
                for (int j = 0; j < result.size() - 1; j++) {
                    list.add(result.get(j) + result.get(j + 1));
                }
                list.add(result.get(result.size() - 1));
            }
            result = list;
        }
        return result;
    }
}
