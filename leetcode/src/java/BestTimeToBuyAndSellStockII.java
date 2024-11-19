public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII instance = new BestTimeToBuyAndSellStockII();
        System.out.println(instance.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(instance.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(instance.maxProfit(new int[]{7,6,4,3,1}));
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length > 1) {
            int lastMinPrice = -1;
            int lastPrice = -1;
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                if (lastMinPrice == -1) {
                    lastMinPrice = price;
                } else if (price < lastPrice) {
                    if (lastMinPrice < lastPrice) {
                        result += lastPrice - lastMinPrice;
                        lastMinPrice = price;
                    }
                    if (lastMinPrice > price) {
                        lastMinPrice = price;
                    }
                } else if (i == prices.length - 1) {
                    result += price - lastMinPrice;
                }
                lastPrice = price;
            }
        }
        return result;
    }
}
