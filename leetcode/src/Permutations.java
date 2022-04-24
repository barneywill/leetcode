import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations instance = new Permutations();
        System.out.println(instance.permute(new int[]{1,2,3}));
        System.out.println(instance.permute(new int[]{0,1}));
        System.out.println(instance.permute(new int[]{1}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result.add(Arrays.asList(nums[i]));
            } else {
                List<List<Integer>> nextResult = new ArrayList<List<Integer>>();
                for (List<Integer> list : result) {
                    for (int j = 0; j < list.size(); j++) {
                        List<Integer> tmp = new ArrayList<Integer>(list);
                        tmp.add(j, nums[i]);
                        nextResult.add(tmp);
                    }
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(nums[i]);
                    nextResult.add(tmp);
                }
                result.clear();
                result = nextResult;
            }
        }
        return result;
    }
}
