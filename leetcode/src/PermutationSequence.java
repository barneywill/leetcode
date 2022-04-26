import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    //TODO:
    public static void main(String[] args) {
        PermutationSequence instance = new PermutationSequence();
        System.out.println(instance.getPermutation(3, 3));
        System.out.println(instance.getPermutation(4, 9));
        System.out.println(instance.getPermutation(3, 3));
    }
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
        if (n == 1) {
            result.append("1");
        } else {
            int[] count = new int[n - 1];
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n - 1; i++) {
                list.add(i + 1);
                if (i == 0) {
                    count[i] = 1;
                } else {
                    count[i] = count[i - 1] * (i + 1);
                }
            }
            list.add(n);
            for (int c : count) {
                System.out.print(c + ",");
            }
            System.out.println();
            for (int i = n - 2; i >= 0; i--) {
                System.out.println("result : " + result + ", " + k);
                int devide = k / count[i];
                result.append(list.remove(devide));
                k = k % count[i];
                if (k == 0) {
                    for (Integer left : list) {
                        result.append(left);
                    }
                }
            }
        }
        return result.toString();
    }
}
