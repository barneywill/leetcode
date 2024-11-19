import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations instance = new Combinations();
        System.out.println(instance.combine(4, 2));
        System.out.println(instance.combine(1, 1));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        if (k > n) {
            return result;
        } else if (k == n || n == 1) {
            result.add(candidates);
        } else if (k == 1) {
            for (int i = 1; i <= n; i++) {
                result.add(Arrays.asList(i));
            }
        } else {
            result = subcombine(new ArrayList<List<Integer>>(), candidates, k);
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
