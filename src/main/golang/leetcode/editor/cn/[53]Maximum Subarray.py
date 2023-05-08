from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def maxSubArray(self, nums: List[int]) -> int:
        # n = len(nums)
        # dp = [0] * n
        # ans = dp[0] = nums[0]
        # for i in range(1, n):
        #     dp[i] = max(dp[i - 1], 0) + nums[i]
        #     ans = max(ans, dp[i])
        # return ans
        def maxCrossing(left: int, mid: int, right: int):
            s1 = 0
            l = r = 0
            for i in range(mid - 1, left - 1, -1):
                s1 += nums[i]
                l = max(l, s1)
            s2 = 0
            for i in range(mid + 1, right + 1):
                s2 += nums[i]
                r = max(r, s2)
            return l + r + nums[mid]

        def maxSub0(left: int, right: int):
            if left == right:
                return nums[left]
            mid = (left + right) >> 1
            return max(maxSub0(left, mid), maxSub0(mid + 1, right), maxCrossing(left, mid, right))

        return maxSub0(0, len(nums) - 1)
# leetcode submit region end(Prohibit modification and deletion)
