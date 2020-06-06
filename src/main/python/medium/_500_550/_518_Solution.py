# 518. Coin Change 2
from typing import List


class _518_Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for price in range(1, amount + 1):
                if price < coin: continue
                dp[price] += dp[price - coin]
        return dp[amount]

'''
5
[1,2,5]
4
[]
1
[1]
0
[]
0
[1]
'''
if __name__ == '__main__':
    obj = _518_Solution()
    assert obj.change(5, [1, 2, 5]) == 4
    assert obj.change(3, [2]) == 0
    assert obj.change(10, [10]) == 1
