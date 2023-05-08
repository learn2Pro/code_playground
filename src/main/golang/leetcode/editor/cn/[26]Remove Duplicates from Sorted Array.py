from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        i, j = 0, 0
        while i < n:
            if nums[i] != nums[j]:
                j += 1
                nums[i], nums[j] = nums[j], nums[i]
            i += 1
        return j + 1
# leetcode submit region end(Prohibit modification and deletion)
