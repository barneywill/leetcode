public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman instance = new IntegerToRoman();
        System.out.println(instance.intToRoman(3));
        System.out.println(instance.intToRoman(58));
        System.out.println(instance.intToRoman(1994));
    }
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int thousandNum = num / 1000;
        if (thousandNum > 0) {
            for (int i = 0; i < thousandNum; i++) {
                result.append("M");
            }
        }
        int hundredNum = num % 1000 / 100;
        if (hundredNum > 0) {
            result.append(translate(hundredNum, "D", "C", "M"));
        }
        int tenNum = num % 100 / 10;
        if (tenNum > 0) {
            result.append(translate(tenNum, "L", "X", "C"));
        }
        int singleNum = num % 10;
        if (singleNum > 0) {
            result.append(translate(singleNum, "V", "I", "X"));
        }
        return result.toString();
    }
    private String translate(int num, String fiveString, String oneString, String tenString) {
        StringBuffer result = new StringBuffer();
        if (num < 5) {
            if (num <= 3) {
                for (int i = 0; i < num; i++) {
                    result.append(oneString);
                }
            } else {
                result.append(oneString).append(fiveString);
            }
        } else {
            if (num == 9) {
                result.append(oneString).append(tenString);
            } else {
                result.append(fiveString);
                if (num > 5) {
                    for (int i = 5; i < num; i++) {
                        result.append(oneString);
                    }
                }
            }
        }
        return result.toString();
    }
}
