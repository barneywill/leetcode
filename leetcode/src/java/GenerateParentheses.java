import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(3));
        System.out.println(instance.generateParenthesis(1));
        //["()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
        //["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
        System.out.println(instance.generateParenthesis(4));
    }
    public List<String> generateParenthesis(int n) {
        return new ArrayList<String>(generateRecursive(new HashSet<String>(Arrays.asList("(")), 1, n - 1));
    }
    public Set<String> generateRecursive(Set<String> resultPrevious, int stack, int remain) {
        Set<String> result = new HashSet<String>();
        if (remain == 0) {
            if (stack > 0) {
                String suffix = "";
                for (int i = 0; i < stack; i++) {
                    suffix += ")";
                }
                result = getResultList(resultPrevious, suffix);
            }
        }
        if (stack > 0) {
            result.addAll(generateRecursive(getResultList(resultPrevious, ")"), stack - 1, remain));
        }
        if (remain > 0) {
            result.addAll(generateRecursive(getResultList(resultPrevious, "("), stack + 1, remain - 1));
        }
        return result;
    }
    private Set<String> getResultList(Set<String> list, String c) {
        Set<String> result = new HashSet<String>();
        for (String str : list) {
            result.add(str + c);
        }
        return result;
    }
}
