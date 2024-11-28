from typing import List

class BestTimeToBuyAndSellStock:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = -1
        result = 0
        for price in prices:
            if min_price == -1:
                min_price = price
            elif price < min_price:
                min_price = price
            elif price - min_price > result:
                result = price - min_price
        return result