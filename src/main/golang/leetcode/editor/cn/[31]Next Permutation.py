from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        i, j = n - 2, n - 1
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        if i >= 0:
            while i < j and nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]
        k, m = n - 1, i + 1
        while m < k:
            nums[m], nums[k] = nums[k], nums[m]
            m, k = m + 1, k - 1
# leetcode submit region end(Prohibit modification and deletion)
