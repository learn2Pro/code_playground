from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        l = r = 0
        while r < n:
            if nums[r] == 0:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
            r += 1
        r = l
        while r < n:
            if nums[r] == 1:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
            r += 1

# leetcode submit region end(Prohibit modification and deletion)
