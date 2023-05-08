from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # def removeElement(self, nums: List[int], val: int) -> int:
    #     n = len(nums)
    #     i, j = 0, n - 1
    #     while j >= 0 and nums[j] == val: j -= 1
    #     while i < j:
    #         if nums[i] == val:
    #             nums[i], nums[j] = nums[j], nums[i]
    #             while j >= 0 and nums[j] == val: j -= 1
    #         i += 1
    #     return j + 1
    def removeElement(self, nums: List[int], val: int) -> int:
        n = len(nums)
        i, j = 0, 0
        while j < n:
            if nums[j] != val:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
            j += 1
        return i
# leetcode submit region end(Prohibit modification and deletion)
