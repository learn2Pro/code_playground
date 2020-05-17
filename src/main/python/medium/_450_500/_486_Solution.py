# 486. Predict the Winner
from typing import List


class _486_Solution:
    # def PredictTheWinner(self, nums: List[int]) -> bool:

    # def backtrack(lo: int, hi: int, acc0: int, turn: int) -> bool:
    #     if lo > hi:
    #         return acc0 >= 0
    #     if turn < 0:
    #         return backtrack(lo + 1, hi, acc0 + nums[lo] * turn, -turn) & backtrack(lo, hi - 1, acc0 + nums[hi] * turn,
    #                                                                             -turn)
    #     else:
    #         return backtrack(lo + 1, hi, acc0 + nums[lo] * turn, -turn) | backtrack(lo, hi - 1, acc0 + nums[hi] * turn,
    #                                                                             -turn)
    #
    # return backtrack(0, len(nums) - 1, 0, 1)
    # memorize

    def PredictTheWinner(self, nums: List[int]) -> bool:
        size = len(nums)
        dp = [[0] * size for _ in range(size)]

        def backtrack(lo: int, hi: int, acc0: int, turn: int) -> bool:
            if lo > hi:
                return acc0 >= 0
            if dp[lo][hi] != 0: return dp[lo][hi] > 0
            if turn < 0:
                ans0 = backtrack(lo + 1, hi, acc0 + nums[lo] * turn, -turn) & backtrack(lo, hi - 1,
                                                                                        acc0 + nums[hi] * turn,
                                                                                        -turn)
                dp[lo][hi] = ans0
            else:
                ans1 = backtrack(lo + 1, hi, acc0 + nums[lo] * turn, -turn) | backtrack(lo, hi - 1,
                                                                                        acc0 + nums[hi] * turn,
                                                                                        -turn)
                dp[lo][hi] = ans1
            return dp[lo][hi] > 0

        return backtrack(0, len(nums) - 1, 0, 1)

    def PredictTheWinner(self, nums: List[int]) -> bool:
        size = len(nums)
        dp = [[0] * size for _ in range(size)]
        for i in range(size):
            dp[i][i] = nums[i]
        for l in range(1, size):
            for i in range(0, size - l):
                end = i + l
                dp[i][end] = max(nums[i] - dp[i + 1][end], nums[end] - dp[i][end - 1])
        return dp[0][size - 1] >= 0


'''
[1,5,2]
[1,5,233,7]
[1,200000,3,4,5,6,7,8,1110,1]
[1,200000,3,4,5,6,7,8,1110,1,1,200000,3,4,5,6,7,8,1110,1]
[601,49373,38681,14134,577,28610,57699,258,19236,88206,490,202,73112,526,39634,811,1032,28458,462]
'''
if __name__ == '__main__':
    target = _486_Solution()
    assert not target.PredictTheWinner(
        [601, 49373, 38681, 14134, 577, 28610, 57699, 258, 19236, 88206, 490, 202, 73112, 526, 39634, 811, 1032, 28458,
         462])
    assert not target.PredictTheWinner([1, 5, 2])
    assert target.PredictTheWinner([1, 5, 233, 7])
