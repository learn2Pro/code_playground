from sys import stdin
from typing import List


def record_breaker(size, lst: List[int]):
    if size > 1 and all(map(lambda x: x == lst[0], lst)): return 0
    stack, ans, maximal = [], 0, -1
    for item in lst:
        if not stack or item >= stack[-1]:
            stack.append(item)
        else:
            ans += 1 if stack[-1] > maximal else 0
            maximal = max(maximal, stack[-1])
    ans += 1 if stack and stack[-1] != maximal else 0
    return ans


def echo():
    size = int(stdin.readline())
    for i in range(size):
        s0 = int(stdin.readline())
        splits = [num for num in map(lambda x: int(x), stdin.readline().split(' '))]
        ans = record_breaker(s0, splits)
        print("Case #{}: {}".format(i + 1, ans))


if __name__ == '__main__':
    echo()
