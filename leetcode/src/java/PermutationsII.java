import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII instance = new PermutationsII();
        System.out.println(instance.permuteUnique(new int[]{1,1,2}));
        System.out.println(instance.permuteUnique(new int[]{1,1,1,2}));
        System.out.println(instance.permuteUnique(new int[]{1,1,2,2}));
        System.out.println(instance.permuteUnique(new int[]{1,2,3}));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> keys = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result.add(Arrays.asList(nums[i]));
            } else {
                List<List<Integer>> nextResult = new ArrayList<List<Integer>>();
                Set<String> nextKeys = new HashSet<String>();
                for (List<Integer> list : result) {
                    for (int j = 0; j < list.size(); j++) {
                        if (nums[i] == list.get(j)) {
                            continue;
                        }
                        List<Integer> tmp = new ArrayList<Integer>(list);
                        tmp.add(j, nums[i]);
                        add(nextResult, tmp, nextKeys);
                    }
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(nums[i]);
                    add(nextResult, tmp, nextKeys);
                }
                result.clear();
                result = nextResult;
                keys.clear();
                keys = nextKeys;
            }
        }
        return result;
    }
    private void add(List<List<Integer>> nextResult, List<Integer> tmp, Set<String> keys) {
        StringBuffer key = new StringBuffer();
        for (Integer in : tmp) {
            key.append(in);
        }
        if (!keys.contains(key.toString())) {
            keys.add(key.toString());
            nextResult.add(tmp);
        }
    }
}
