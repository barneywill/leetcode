public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII instance = new UglyNumberII();
        System.out.println(instance.nthUglyNumber(4));
        System.out.println(instance.nthUglyNumber(6));
        System.out.println(instance.nthUglyNumber(11));
        System.out.println(instance.nthUglyNumber(22));
        System.out.println(instance.nthUglyNumber(1690));
    }
    public int nthUglyNumber(int n) {
        int result = 1;
        int multiply = 40000;
        int[] arr = new int[multiply * n];
        arr[1] = 1;
        int twoLoop = 2;
        int threeLoop = 2;
        int fiveLoop = 2;
        for (int i = 2; i < multiply * n; i++) {
            if (twoLoop == 2 || threeLoop == 3 || fiveLoop == 5) {
                arr[i] = 1;
            }
            twoLoop = twoLoop % 2 + 1;
            threeLoop = threeLoop % 3 + 1;
            fiveLoop = fiveLoop % 5 + 1;
        }
        for (int i = 1; i < multiply * n; i++) {
            if (arr[i] == 0) {
                int current = i;
                while (current < multiply * n) {
                    arr[current] = 0;
                    current += i;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < multiply * n; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == n) {
                    result = i;
                    break;
                }
            }
            if (i == multiply * n - 1) {
                System.out.println("in the end : " + count);
            }
        }
        return result;
    }
}
