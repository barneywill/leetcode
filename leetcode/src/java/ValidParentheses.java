import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses instance = new ValidParentheses();
        System.out.println(instance.isValid("()"));
        System.out.println(instance.isValid("()[]{}"));
        System.out.println(instance.isValid("(]"));
    }
    public boolean isValid(String s) {
        Set<Character> startSet = new HashSet<Character>(Arrays.asList('(', '{', '['));
        List<Character> list = new LinkedList<Character>();
        for (int i = 0, n = s.length(); i < n; i++) {
            if (list.isEmpty() || (startSet.contains(s.charAt(i)) && startSet.contains(list.get(0)))) {
                list.add(0, s.charAt(i));
            } else if ((list.get(0) == '(' && s.charAt(i) == ')') ||
                    (list.get(0) == '{' && s.charAt(i) == '}') ||
                    (list.get(0) == '[' && s.charAt(i) == ']')) {
                list.remove(0);
            } else {
                break;
            }
        }
        return list.isEmpty();
    }
}
