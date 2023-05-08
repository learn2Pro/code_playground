from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # n = len(nums)
        # for i, x in enumerate(nums):
        #     if x <= 0:
        #         nums[i] = n + 1
        # for i, x in enumerate(nums):
        #     loc = abs(x)
        #     if loc <= n:
        #         nums[loc - 1] = -abs(nums[loc - 1])
        # for i, num in enumerate(nums):
        #     if num > 0:
        #         return i + 1
        # return n + 1
        n = len(nums)
        for i, _ in enumerate(nums):
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
        for i, num in enumerate(nums):
            if i + 1 != num:
                return i + 1
        return n + 1
# leetcode submit region end(Prohibit modification and deletion)
