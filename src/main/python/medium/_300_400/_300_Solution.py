# 300. Longest Increasing Subsequence
import bisect
from typing import List

'''
[10,9,2,5,3,7,101,18]
[1,1,1]
[4,10,4,3,8,9]
[3]
[2,3]
[1, 3, 6, 7, 9, 4, 10, 5, 6]
'''


class _300_Solution:
    # bisect
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        ans = []
        for num in nums:
            idx = bisect.bisect_left(ans, num)
            if idx >= len(ans):
                ans.append(num)
            else:
                ans[idx] = num
        return len(ans)
    # dp
    # def lengthOfLIS(self, nums: List[int]) -> int:
    #     if not nums: return 0
    #     n = len(nums)
    #     dp = [1] * n
    #     maximal = 1
    #     for i in range(1, n):
    #         for j in range(i):
    #             if nums[i] > nums[j]:
    #                 dp[i] = max(dp[i], dp[j] + 1)
    #                 maximal = max(maximal, dp[i])
    #     return maximal


if __name__ == '__main__':
    instance = _300_Solution()
    assert instance.lengthOfLIS([1, 3, 6, 7, 9, 4, 10, 5, 6]) == 6
    assert instance.lengthOfLIS([4, 10, 4, 3, 8, 9]) == 3
    assert instance.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]) == 4
