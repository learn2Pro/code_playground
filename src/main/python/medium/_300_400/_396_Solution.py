# 396. Rotate Function
from typing import List


class _396_Solution:
    def maxRotateFunction(self, A: List[int]) -> int:
        n = len(A)
        s0, s1 = sum(A), sum(i * A[i] for i in range(n))
        maximal = s1
        for next in A:
            s1 += n * next - s0
            maximal = max(maximal, s1)
        return maximal
