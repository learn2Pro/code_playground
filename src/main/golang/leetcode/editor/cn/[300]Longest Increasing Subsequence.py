from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # n = len(nums)
        # if n < 2: return n
        # dp = [1] * n
        # for i in range(1, n):
        #     for j in range(i):
        #         if nums[j] >= nums[i]: continue
        #         dp[i] = max(dp[i], dp[j] + 1)
        # return max(dp)
        n = len(nums)
        if n < 2: return n
        dp = [nums[0]]
        size = 1
        for i in range(1, n):
            if nums[i] > dp[-1]:
                dp.append(nums[i])
                size += 1
            else:
                l, r = 0, len(dp)
                while l < r:
                    mid = (l + r) // 2
                    if dp[mid] < nums[i]:
                        l = mid + 1
                    else:
                        r = mid
                dp[l] = nums[i]
        return size
# leetcode submit region end(Prohibit modification and deletion)
