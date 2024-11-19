import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle instance = new PascalsTriangle();
        List<List<Integer>> result = instance.generate(5);
        for (List<Integer> item : result) {
            System.out.println(item);
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
            } else {
                List<Integer> lastList = result.get(result.size() - 1);
                list.add(lastList.get(0));
                for (int j = 0; j < lastList.size() - 1; j++) {
                    list.add(lastList.get(j) + lastList.get(j + 1));
                }
                list.add(lastList.get(lastList.size() - 1));
            }
            result.add(list);
        }
        return result;
    }
}
