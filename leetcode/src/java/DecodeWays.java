import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays instance = new DecodeWays();
//        System.out.println(instance.numDecodings("2101"));
//        System.out.println(instance.numDecodings("2611055971756562"));
        System.out.println(instance.numDecodings("111111111111111111111111111111111111111111111"));
    }
    public int numDecodings(String s) {
        int[] nums = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                nums[i] = 1;
            } else if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    nums[i] = i >= 2 ? nums[i - 2] : 1;
                }
                else {
                    return 0;
                }
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    nums[i] = nums[i - 1] + (i >= 2 ? nums[i - 2] : 1);
                } else {
                    nums[i] = nums[i - 1];
                }
            } else if (s.charAt(i - 1) == '1') {
                nums[i] = nums[i - 1] + (i >= 2 ? nums[i - 2] : 1);
            } else {
                nums[i] = nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
//    public int numDecodings(String s) {
////        return numDecodings(s, 0, new ArrayList<String>()).size();
//        return numDecodings(s, 0);
//    }
//    private List<String> newPreList(List<String> preList, String s, int index, int length) {
//        List<String> newPreList = new ArrayList<String>(preList);
//        newPreList.add(String.valueOf(s.substring(index, index + length)));
//        return newPreList;
//    }
//    private void add(List<List<String>> result, List<List<String>> tmpResult) {
//        if (tmpResult != null && !tmpResult.isEmpty()) {
//            result.addAll(tmpResult);
//        }
//    }
//    private List<List<String>> numDecodings(String s, int index, List<String> preList) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        if (index == s.length()) {
//            result.add(preList);
//        } else {
//            if (s.charAt(index) == '0') {
//
//            } else if (s.charAt(index) == '1' || s.charAt(index) == '2') {
//                if (index < s.length() - 1) {
//                    if (s.charAt(index + 1) == '0') {
//                        add(result, numDecodings(s, index + 2, newPreList(preList, s, index, 2)));
//                    } else {
//                        add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
//                        if (s.charAt(index + 1) >= '1' && s.charAt(index + 1) <= '6') {
//                            add(result, numDecodings(s, index + 2, newPreList(preList, s, index, 2)));
//                        }
//                    }
//                } else {
//                    add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
//                }
//            } else {
//                add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
//            }
//        }
//        return result;
//    }
//    private int numDecodings(String s, int index) {
//        int result = 0;
//        if (index == s.length()) {
//            result = 1;
//        } else {
//            if (s.charAt(index) == '0') {
//
//            } else if (s.charAt(index) == '1' || s.charAt(index) == '2') {
//                if (index < s.length() - 1) {
//                    if (s.charAt(index + 1) == '0') {
//                        result += numDecodings(s, index + 2);
//                    } else {
//                        result += numDecodings(s, index + 1);
//                        if (s.charAt(index) == '1' || (s.charAt(index + 1) >= '1' && s.charAt(index + 1) <= '6')) {
//                            result += numDecodings(s, index + 2);
//                        }
//                    }
//                } else {
//                    result += numDecodings(s, index + 1);
//                }
//            } else {
//                result += numDecodings(s, index + 1);
//            }
//        }
//        return result;
//    }
}
