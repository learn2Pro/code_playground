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
        piles, n = 0, len(nums)
        top = [0] * n
        for i in range(n):
            poker = nums[i]
            left, right = 0, piles
            ## 找到>=poker的最左边的堆
            while left < right:
                mid = (left + right) // 2
                if top[mid] < poker:
                    left = mid + 1
                else:
                    right = mid
            if left == piles:
                piles += 1
            top[left] = poker
        return piles
# leetcode submit region end(Prohibit modification and deletion)
