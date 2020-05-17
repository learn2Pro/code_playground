# 494. Target Sum
from typing import List


class _494_Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        acc, size = sum(nums), len(nums)
        if not nums or abs(S) > acc: return 0
        dp = [[0] * (2 * acc + 1) for _ in range(size)]
        dp[0][nums[0] + acc] = 1
        dp[0][-nums[0] + acc] = 1
        for i in range(1, size):
            for j in range(2 * acc + 1):
                if dp[i - 1][j] == 0: continue
                dp[i][j + nums[i]] += dp[i - 1][j]
                dp[i][j - nums[i]] += dp[i - 1][j]
        return dp[size - 1][S + acc]

    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        acc, size = sum(nums), len(nums)
        if not nums or abs(S) > acc or (S + acc) % 2 != 0: return 0
        target = (S + acc) // 2
        dp = [0] * (target + 1)
        dp[0] = 1
        for num in nums:
            for i in reversed(range(num, target + 1)):
                dp[i] += dp[i - num]
        return dp[target]


'''
[1,1,1,1,1]
3
[0,0,0,0,0,0,0,0,1]
1
'''
if __name__ == '__main__':
    target = _494_Solution()
    assert target.findTargetSumWays([1], 2) == 0
    assert target.findTargetSumWays([1, 1, 1, 1, 1], 3) == 5
