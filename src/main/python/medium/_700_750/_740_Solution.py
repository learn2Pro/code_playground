# 740. Delete and Earn
import collections
from typing import List


class _740_Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        counter = collections.Counter(nums)
        t0 = t1 = 0
        for i in range(1, 10001):
            t0, t1 = max(t0, t1), t0 + counter.get(i, 0) * i
        return max(t0, t1)

    # optimized
    def deleteAndEarn(self, nums: List[int]) -> int:
        acc, maximal, minimal = [0] * 10001, 0, 10001
        for num in nums:
            acc[num] += 1
            maximal = max(maximal, num)
            minimal = min(minimal, num)
        t0 = t1 = 0
        for i in range(minimal, maximal + 1):
            t0, t1 = max(t0, t1), t0 + acc[i] * i
        return max(t0, t1)
