import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence instance = new PermutationSequence();
        System.out.println(instance.getPermutation(3, 3));
        System.out.println(instance.getPermutation(4, 9));
        System.out.println(instance.getPermutation(3, 1));
        System.out.println(instance.getPermutation(2, 2));
    }
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
        if (n == 1) {
            result.append("1");
        } else if (n == 2) {
            if (k == 1) {
                result.append("12");
            } else {
                result.append("21");
            }
        } else {
            int[] count = new int[n - 1];
            List<Byte> list = new ArrayList<Byte>();
            for (int i = 0; i < n - 1; i++) {
                list.add((byte)(i + 1));
                if (i == 0) {
                    count[i] = 1;
                } else {
                    count[i] = count[i - 1] * (i + 1);
                }
            }
            list.add((byte)n);
//            for (int c : count) {
//                System.out.print(c + ",");
//            }
//            System.out.println();
            k -= 1;
            if (k > 0) {
                for (int i = n - 2; i >= 0; i--) {
//                System.out.println("result : " + result + ", " + k);
                    if (k == 0) {
                        break;
                    }
                    int divide = k / count[i];
                    result.append(list.remove(divide));
                    k = k % count[i];
                }
            }
            for (Byte left : list) {
                result.append(left);
            }
        }
        return result.toString();
    }
}
