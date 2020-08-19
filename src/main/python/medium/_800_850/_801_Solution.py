# 801. Minimum Swaps To Make Sequences Increasing
from typing import List

'''
[1,3,5,4]
[1,2,3,7]
[1,3,7,6]
[1,3,5,8]
'''
class _801_Solution:
    # use array
    def minSwap(self, A: List[int], B: List[int]) -> int:
        N = len(A)
        no_swap, swap = [N] * N, [N] * N
        no_swap[0], swap[0] = 0, 1
        for i in range(1, N):
            if A[i - 1] < A[i] and B[i - 1] < B[i]:
                no_swap[i], swap[i] = no_swap[i - 1], swap[i - 1] + 1
            if A[i - 1] < B[i] and B[i - 1] < A[i]:
                no_swap[i], swap[i] = min(no_swap[i], swap[i - 1]), min(swap[i], no_swap[i - 1] + 1)
        return min(no_swap[-1], swap[-1])

    def minSwap(self, A: List[int], B: List[int]) -> int:
        no_swap, swap = 0, 1
        N = len(A)
        for i in range(1, N):
            no_swap0, swap0 = 0x7fffffff, 0x7fffffff
            if A[i - 1] < A[i] and B[i - 1] < B[i]:
                no_swap0 = min(no_swap0, no_swap)
                swap0 = min(swap0, swap + 1)
            if A[i - 1] < B[i] and B[i - 1] < A[i]:
                no_swap0, swap0 = min(no_swap0, swap), min(swap0, no_swap + 1)
            no_swap, swap = no_swap0, swap0
        return min(no_swap, swap)
