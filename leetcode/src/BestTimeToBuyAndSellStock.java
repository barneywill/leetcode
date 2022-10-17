public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        System.out.println(instance.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(instance.maxProfit(new int[]{7,6,4,3,1}));
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        int lowest = 10000;
        for (int price : prices) {
            if (lowest > price) {
                lowest = price;
            } else {
                if (price - lowest > result) {
                    result = price - lowest;
                }
            }
        }
        return result;
    }
}
