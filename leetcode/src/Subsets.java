import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets instance = new Subsets();
        System.out.println(instance.subsets(new int[]{1,2,3}));
        System.out.println(instance.subsets(new int[]{0}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        List<Integer> candidates = new ArrayList<Integer>();
        for (int num : nums) {
            candidates.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            result.addAll(subcombine(new ArrayList<List<Integer>>(), candidates, i));
        }
        return result;
    }
    private List<List<Integer>> subcombine(List<List<Integer>>prefixs, List<Integer> candidates, int left) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (left == 0) {
            result = prefixs;
        } else {
            for (int i = 0; i <= candidates.size() - left; i++) {
                List<List<Integer>> newPrefixs = new ArrayList<List<Integer>>();
                if (prefixs.isEmpty()) {
                    newPrefixs.add(Arrays.asList(candidates.get(i)));
                } else {
                    for (List<Integer> prefix : prefixs) {
                        List<Integer> newPrefix = new ArrayList<Integer>(prefix);
                        newPrefix.add(candidates.get(i));
                        newPrefixs.add(newPrefix);
                    }
                }
                if (left == 1) {
                    result.addAll(newPrefixs);
                } else {
                    List<Integer> newCandidates = new ArrayList<Integer>();
                    for (int j = i + 1; j < candidates.size(); j++) {
                        newCandidates.add(candidates.get(j));
                    }
                    result.addAll(subcombine(newPrefixs, newCandidates, left - 1));
                }
            }
        }
        return result;
    }
}
