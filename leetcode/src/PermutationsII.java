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
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result.add(Arrays.asList(nums[i]));
            } else {
                List<List<Integer>> nextResult = new ArrayList<List<Integer>>();
                for (List<Integer> list : result) {
                    for (int j = 0; j < list.size(); j++) {
                        if (nums[i] == list.get(j)) {
                            continue;
                        }
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
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> item = result.get(i);
            StringBuffer key = new StringBuffer();
            for (Integer in : item) {
                key.append(in);
            }
            if (!set.contains(key.toString())) {
                set.add(key.toString());
            } else {
                result.remove(i--);
            }
        }
        return result;
    }
}
