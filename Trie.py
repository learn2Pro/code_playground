from sys import stdin
from typing import List


class Trie:
    def __init__(self):
        self.lookup = {}

    def add(self, word: str):
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current['_'] = word

    def delete(self, word: str):
        current = self.lookup
        for c in word:
            if c not in current: return
            current = current[c]
        del current['_']

    def contains(self, word: str):
        current = self.lookup
        for c in word:
            if c not in current: return False
            current = current[c]
        return '_' in current

    def prefixCount(self, prefix: str):
        current = self.lookup
        for c in prefix:
            if c not in current: return 0
            current = current[c]

        def dfs(lookup):
            if not lookup:
                return 0
            size0 = 1 if '_' in lookup else 0
            for k, v in lookup.items():
                if k == '_': continue
                size0 += dfs(v)
            return size0

        return dfs(current)


def _01bag2d(num, value: List[int], weight: List[int]):
    size = len(value)
    dp = [[0] * (num + 1) for _ in range(size + 1)]
    for i in range(size):
        used, profit = weight[i], value[i]
        for remain in range(num + 1):
            if remain >= used:
                dp[i][remain] = max(dp[i - 1][remain], dp[i - 1][remain - used] + profit)
            else:
                dp[i][remain] = dp[i - 1][remain]
    return dp[-1][-1]


def _01bag1d(num, value: List[int], weight: List[int]):
    size = len(value)
    dp = [0] * (num + 1)
    for i in range(size):
        used, profit = weight[i], value[i]
        for step in reversed(range(num + 1)):
            if step >= used:
                dp[step] = max(dp[step], dp[step - used] + profit)
    return dp[-1]


# 121. Best Time to Buy and Sell Stock
# [7,1,5,3,6,4]
# d0 i-index,d1 transctions,d2 current had stock
# T[i][1][0] = max(T[i-1][1][0],T[i-1][1][1]+prices[i])
# T[i][1][1] = max(T[i-1][1][1],T[i-1][0][0]-prices[i])
def _stock0(prices: List[int]):
    t_i10 = t_i11 = -0x7fffffff
    for price in prices:
        t_i10 = max(t_i10, t_i11 + price)
        t_i11 = max(t_i11, -price)
    return max(t_i11, t_i10)


# 122. Best Time to Buy and Sell Stock II
# T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])
# T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0]-prices[i])
def _stock1(prices: List[int]):
    t_ik0 = t_ik1 = -0x7fffffff
    for price in prices:
        t_ik0, t_ik1 = max(t_ik0, t_ik1 + price), max(t_ik1, t_ik0 - price)
    return max(t_ik0, t_ik1)


# 123. Best Time to Buy and Sell Stock III
# T[i][1][0] = max(T[i-1][1][0],T[i-1][1][1]+prices[i])
# T[i][1][1] = max(T[i-1][1][1],T[i-1][0][0]-prices[i]) = max(T[i-1][1][1],-prices[i])
# T[i][2][0] = max(T[i-1][2][0],T[i-1][2][1]+prices[i])
# T[i][2][1] = max(T[i-1][2][1],T[i-1][1][0]-prices[i])
def _stock2(prices: List[int]):
    t_i10 = t_i11 = t_i20 = t_i21 = -0x7fffffff
    for price in prices:
        t_i10, t_i11, t_i20, t_i21 = max(t_i10, t_i11 + price), max(t_i11, -price), max(t_i20, t_i21 + price), max(
            t_i21, t_i10 - price)
    return max(t_i10, t_i11, t_i20, t_i21)


# 188. Best Time to Buy and Sell Stock IV
# if k>len(prices)//2,fallback to _stock2
# else:
# T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])
# T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0]-prices[i])
# T[i][0][0] = 0,T[i][0][1]=-0x7fffffff
def _stock3(k: int, prices: List[int]):
    if k > len(prices) >> 1:
        return _stock2(prices)
    t_k0, t_k1 = [0] * (k + 1), [-0x7fffffff] * (k + 1)
    for price in prices:
        for time in reversed(range(1, k + 1)):
            t_k0[time] = max(t_k0[time], t_k1[time] + price)
            t_k1[time] = max(t_k1[time], t_k0[time - 1] - price)
    return max(t_k0[-1], t_k1[-1])


# 309. Best Time to Buy and Sell Stock with Cooldown
# After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
# T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])
# T[i-1][k][1] = max(T[i-1][k][1],T[i-2][k-1][0]-prices[i])
def _stock4(prices: List[int]):
    t_ik0_pre = t_ik0 = 0
    t_ik1 = -0x7fffffff
    for price in prices:
        t_ik0, t_ik1, t_ik0_pre = max(t_ik0, t_ik1 + price), max(t_ik1, t_ik0_pre - price), t_ik0
    return max(t_ik1, t_ik0)


# 714. Best Time to Buy and Sell Stock with Transaction Fee
# You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
# You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
# T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])
# T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0]-prices[i]-fee)
def _stock5(fee: int, prices: List[int]):
    t_ik0, t_ik1 = 0, -0x7fffffff
    for price in prices:
        t_ik0, t_ik1 = max(t_ik0, t_ik1 + price), max(t_ik1, t_ik0 - price - fee)
    return max(t_ik0, t_ik1)


def echo():
    trie = Trie()
    num = int(stdin.readline())
    for i in range(num):
        input = stdin.read().split(" ")
        op = int(input[0])
        word = input[1]
        if op == 1:
            trie.add(word)
        elif op == 2:
            trie.delete(word)
        elif op == 3:
            print('YES' if trie.contains(word) else 'NO')
        elif op == 4:
            print(trie.prefixCount(word))


if __name__ == '__main__':
    echo()
    assert _01bag1d(50, [60, 100, 120], [10, 20, 30]) == 220
    trie = Trie()
    trie.add('qwer')
    trie.add('qwe')
    assert trie.contains("qwer")
    assert trie.prefixCount("q") == 2
    trie.delete('qwer')
    assert not trie.contains("qwer")
    assert trie.prefixCount("q") == 1
