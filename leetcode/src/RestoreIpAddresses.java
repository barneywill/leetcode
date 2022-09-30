import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses instance = new RestoreIpAddresses();
        List<String> result = instance.restoreIpAddresses("25525511135");
        for (String ip : result) {
            System.out.println(ip);
        }
        result = instance.restoreIpAddresses("0000");
        for (String ip : result) {
            System.out.println(ip);
        }
        result = instance.restoreIpAddresses("101023");
        for (String ip : result) {
            System.out.println(ip);
        }
        result = instance.restoreIpAddresses("1111");
        for (String ip : result) {
            System.out.println(ip);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<List<Integer>> ipList = restore(new ArrayList<Integer>(), s);
        for (List<Integer> ip : ipList) {
            StringBuffer sb = new StringBuffer();
            for (Integer num : ip) {
                sb.append(".").append(num);
            }
            sb.deleteCharAt(0);
            result.add(sb.toString());
        }
        return result;
    }
    private List<List<Integer>> restore(List<Integer> restored, String left) {
//        System.out.println(restored + ", " +  left);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (restored.size() == 4) {
            result.add(restored);
        } else if (!left.isEmpty()) {
            try2Restore(result, restored, left, 1);
            if (left.length() > 1 && (left.charAt(0) != '0')) {
                try2Restore(result, restored, left, 2);
                if (left.length() > 2 && (left.charAt(0) == '1' || (left.charAt(0) == '2' && left.charAt(1) < '5') || (left.charAt(0) == '2' && left.charAt(1) == '5' && left.charAt(2) <= '5'))) {
                    try2Restore(result, restored, left, 3);
                }
            }
        }
        return result;
    }
    private void try2Restore(List<List<Integer>> result, List<Integer> restored, String left, Integer size) {
        if (restored.size() < 3 || size == left.length()) {
            List<Integer> nextRestored = new ArrayList<Integer>(restored);
            nextRestored.add(Integer.parseInt(left.substring(0, size)));
            result.addAll(restore(nextRestored, left.substring(size)));
        }
    }
}
