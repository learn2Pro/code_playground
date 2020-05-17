# 454. 4Sum II
import collections
from typing import List


class _454_Solution:
    # use counter
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        AB = collections.Counter(a + b for a in A for b in B)
        return sum(AB[-c - d] for c in C for d in D)

    # use counter 2
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        ab = collections.Counter(a + b for a in A for b in B)
        c = collections.Counter(C)
        d = collections.Counter(D)
        ans = 0
        for k0, v0 in c.items():
            for k1, v1 in d.items():
                if -k0 - k1 in ab:
                    ans += ab[-k0 - k1] * c[k0] * d[k1]
        return ans

    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        A.sort()
        B.sort()
        C.sort()
        D.sort()
        N, ans = len(A), 0
        leftSum = {}
        for i0 in range(N):
            for i1 in range(N):
                left = A[i0] + B[i1]
                leftSum[left] = leftSum.get(left, 0) + 1
        for i2 in range(N):
            for i3 in range(N):
                rightSum = C[i2] + D[i3]
                if -rightSum in leftSum:
                    ans += leftSum[-rightSum]
        return ans
