public class AddBinary {
    public static void main(String[] args) {
        AddBinary instance = new AddBinary();
        System.out.println(instance.addBinary("11", "1"));
        System.out.println(instance.addBinary("1010", "1011"));
    }
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int maxLength = Math.max(a.length(), b.length());
        int plus = 0;
        for (int i = 0; i < maxLength; i++) {
            char c1 = a.length() - 1 < i ? '0' : a.charAt(a.length() - 1 - i);
            char c2 = b.length() - 1 < i ? '0' : b.charAt(b.length() - 1 - i);
            int num = c1 - 48 + c2 - 48 + plus;
            if (num > 1) {
                plus = num / 2;
                num = num % 2;
            } else {
                plus = 0;
            }
            result.append(num);
        }
        if (plus > 0) {
            result.append(plus);
        }
        return result.reverse().toString();
    }
}
