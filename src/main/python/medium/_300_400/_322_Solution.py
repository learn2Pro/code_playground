# 322. Coin Change
from typing import List

'''
[1,2,5]
11
[2]
3
[]
1
[1]
12
[3,7,405,436]
8839
'''


class _322_Solution:
    # dfs
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0: return 0
        usage = sorted(coin for coin in coins if coin <= amount)
        if not usage: return -1
        ans = amount + 1

        def dfs(remain: int, index: int, used: int) -> None:
            nonlocal ans
            q, r = divmod(remain, usage[index])
            if r == 0:
                ans = min(used + q, ans)
                return
            if index == 0 or used + q + 1 >= ans:
                return
            for n in range(q, -1, -1):
                dfs(remain - n * usage[index], index - 1, used + n)

        # def dfs(remain: int, index: int, used: int) -> None:
        #     if remain == 0 or index < 0:
        #         nonlocal ans
        #         if remain == 0: ans = min(ans, used)
        #         return
        #     d, m = divmod(remain, usage[index])
        #     for i in range(d, -1, -1):
        #         dfs(remain - i * usage[index], index - 1, used + i)

        dfs(amount, len(usage) - 1, 0)
        return -1 if ans == amount + 1 else ans

    # dp
    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     if amount == 0: return 0
    #     dp = [amount + 1] * (amount + 1)
    #     dp[0] = 0
    #     for i in range(1, amount + 1):
    #         for coin in coins:
    #             if i < coin: continue
    #             dp[i] = min(dp[i], dp[i - coin] + 1)
    #     return -1 if dp[amount] == amount + 1 else dp[amount]


if __name__ == '__main__':
    instance = _322_Solution()
    assert instance.coinChange([3, 7, 405, 436], 8839) == 10
    assert instance.coinChange([1, 2, 5], 11) == 3
    assert instance.coinChange([2], 3) == -1
