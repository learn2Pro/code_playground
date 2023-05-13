
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        min_price = float('inf')
        for price in prices:
            if price < min_price:
                min_price = price
            else:
                ans = max(ans, price - min_price)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
