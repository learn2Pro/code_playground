# 313. Super Ugly Number
import heapq
from typing import List


class _313_Solution:
    # use heap
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        if n == 1 or not primes: return 1
        ans = []
        heapq.heappush(ans, 1)
        for _ in range(n):
            current = heapq.heappop(ans)
            for prime in primes:
                heapq.heappush(ans, prime * current)
                if current % prime == 0: break
        return current
    # use sliding array
    # def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
    #     if n == 1 or not primes: return 1
    #     l = len(primes)
    #     pointer = [0] * len(primes)
    #     ans = [1]
    #     size = 1
    #     while size < n:
    #         minimal, minIndex = 0x7fffffff, n
    #         for p in range(l):
    #             minimal = min(minimal, ans[pointer[p]] * primes[p])
    #             minIndex = min(minIndex, pointer[p])
    #         for i in range(l):
    #             if ans[pointer[i]] * primes[i] != minimal:
    #                 pointer[i] -= minIndex
    #             else:
    #                 pointer[i] -= (minIndex - 1)
    #         if minIndex > 0:
    #             ans.pop(0)
    #         if minimal != ans[-1]:
    #             ans.append(minimal)
    #             size += 1
    #     return ans[-1]


'''
12
[2, 7, 13, 19]
2
[3,5,6]
1
[]
12
[2, 7, 13, 19]
1212
[2, 7, 13, 19]
1212
[2]
2
[3,5,6]
1
[]
'''
if __name__ == '__main__':
    instance = _313_Solution()
    assert instance.nthSuperUglyNumber(12, [2]) == 2048
    assert instance.nthSuperUglyNumber(12, [2, 7, 13, 19]) == 32
    assert instance.nthSuperUglyNumber(2, [3, 5, 6]) == 3
