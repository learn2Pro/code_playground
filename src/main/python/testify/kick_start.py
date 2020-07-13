from sys import stdin
from typing import List, Iterator


# T[i][b] = max(T[i - 1][b], T[i - 1][b - sales[i]] + 1)
def findmax(budget: int, size: int, sales: Iterator[int]) -> int:
    # dp = [[0] * (budget + 1) for _ in range(len(sales) + 1)]
    dp = [0] * (budget + 1)
    for i in range(size):
        sale = next(sales)
        for j in reversed(range(1, budget + 1)):
            if j >= sale:
                dp[j] = max(dp[j], dp[j - sale] + 1)
    return dp[-1]


def findmax0(budget: int, size: int, sales: Iterator[int]) -> int:
    counter = [0] * (1001)
    for sale in sales:
        counter[sale] += 1
    ans = 0
    for price in range(1, 1001):
        num = counter[price]
        if not num: continue
        if budget >= num * price:
            ans += num
            budget -= (num * price)
        else:
            ans += budget // price
            budget -= (budget // price * price)
            break
    return ans


def echo0():
    size = int(stdin.readline())
    for i in range(size):
        parts = stdin.readline().split(' ')
        lst = map(lambda x: int(x), stdin.readline().split(' '))
        ans = findmax0(int(parts[1]), int(parts[0]), lst)
        print("Case #{}: {}".format(i + 1, ans))


# T[i][P] = max(T[i-1][P],T[i-1][P-1]+value[i-1][1],...,T[i-1][P-k]+value[i-1][k])
def findPlates(N: int, K: int, P: int) -> int:
    dp = [0] * (P + 1)
    for i in range(N):
        parts = stdin.readline().rstrip().split(' ')
        for curr in reversed(range(1, P + 1)):
            beauty = 0
            for i, part in enumerate(parts):
                beauty += int(part)
                if curr >= i + 1:
                    dp[curr] = max(dp[curr], dp[curr - i - 1] + beauty)
    return dp[-1]


def echo1():
    size = int(stdin.readline())
    for i in range(size):
        splits = stdin.readline().split(' ')
        ans = findPlates(int(splits[0]), int(splits[1]), int(splits[2]))
        print("Case #{}: {}".format(i + 1, ans))


if __name__ == '__main__':
    echo1()
