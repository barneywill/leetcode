import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum instance = new CombinationSum();
        System.out.println(instance.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(instance.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(instance.combinationSum(new int[]{2}, 1));
        System.out.println(instance.combinationSum(new int[]{2,7,6,3,5,1}, 9));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = search(candidates, target, new ArrayList<Integer>());
        if (result.size() > 0) {
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < result.size(); i++) {
                Integer[] arr = result.get(i).toArray(new Integer[0]);
                Arrays.sort(arr);
                String key = "";
                for (Integer item : arr) {
                    key += item;
                }
                if (set.contains(key)) {
                    result.remove(i);
                    i--;
                } else {
                    set.add(key);
                }
            }
        }
        return result;
    }
    private List<List<Integer>> search(int[] candidates, int target, List<Integer> prefix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target >= candidates[0] && target <= candidates[candidates.length - 1]) {
            for (int i = 0; i < candidates.length; i++) {
                if (target == candidates[i]) {
                    List<Integer> newPrefix = new ArrayList<Integer>(prefix);
                    newPrefix.add(candidates[i]);
                    result.add(newPrefix);
                    break;
                }
            }
        }
        if (target >= candidates[0]) {
            for (int i = 0; i < candidates.length; i++) {
                if (target - candidates[i] >= candidates[0]) {
                    List<Integer> newPrefix = new ArrayList<Integer>(prefix);
                    newPrefix.add(candidates[i]);
                    result.addAll(search(candidates, target - candidates[i], newPrefix));
                }
            }
        }
        return result;
    }
}
