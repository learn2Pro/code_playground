# 413. Arithmetic Slices
from typing import List

'''
[1,2,3,4]
[]
[1]
[1,2]
[1,2,3]
[1,3,4,5,8,10,12]
'''


class _413_Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A) < 3: return 0
        n, ans = len(A), 0
        curr = sum = 0
        for i in range(2, n):
            if A[i] - A[i - 1] == A[i - 1] - A[i - 2]:
                curr += 1
                sum += curr
            else:
                curr = 0
        return sum


if __name__ == '__main__':
    obj = _413_Solution()
    assert obj.numberOfArithmeticSlices([1, 3, 4, 5, 8, 10, 12]) == 2
