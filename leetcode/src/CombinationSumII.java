import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII instance = new CombinationSumII();
        System.out.println(instance.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(instance.combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(instance.combinationSum2(new int[]{1}, 1));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int candidate : candidates) {
            sum += candidate;
            if (min > candidate) {
                min = candidate;
            }
            if (max < candidate) {
                max = candidate;
            }
        }
        if (min == max) {
            if (target % min == 0 && min * candidates.length >= target) {
                List<Integer> prefix = new ArrayList<Integer>();
                while (target > 0) {
                    prefix.add(min);
                    target -= min;
                }
                result.add(prefix);
            }
        }
        else if (target == sum) {
            List<Integer> candidatesList = new ArrayList<Integer>();
            for (int candidate : candidates) {
                candidatesList.add(candidate);
            }
            result.add(candidatesList);
        } else if (target <= sum && target >= min) {
            Arrays.sort(candidates);
            List<Integer> candidatesList = new ArrayList<Integer>();
            for (int candidate : candidates) {
                candidatesList.add(candidate);
            }
            result = search(candidatesList, target, new ArrayList<Integer>());
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
        }
        return result;
    }
    private List<List<Integer>> search(List<Integer> candidatesList, int target, List<Integer> prefix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target >= candidatesList.get(0) && target <= candidatesList.get(candidatesList.size() - 1)) {
            for (int i = 0; i < candidatesList.size(); i++) {
                if (candidatesList.get(i).equals(target)) {
                    List<Integer> list = new ArrayList<Integer>(prefix);
                    list.add(target);
                    result.add(list);
                    break;
                }
            }
        }
        if (target >= candidatesList.get(0) && candidatesList.size() > 1) {
            for (int i = 0; i < candidatesList.size(); i++) {
                if (target - candidatesList.get(i) >= (i == 0 ? candidatesList.get(1) : candidatesList.get(i - 1))) {
                    List<Integer> nextCandidates = new ArrayList<Integer>(candidatesList);
                    nextCandidates.remove(i);
                    List<Integer> newPrefix = new ArrayList<Integer>(prefix);
                    newPrefix.add(candidatesList.get(i));
                    result.addAll(search(nextCandidates, target - candidatesList.get(i), newPrefix));
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
