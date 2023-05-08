from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l, r = 0, len(nums)
        while l < r:
            m = l + r >> 1
            if nums[m] == target:
                return True
            if nums[m] == nums[l]:
                l += 1
            elif nums[m] > nums[l]:
                if nums[l] <= target < nums[m]:
                    r = m
                else:
                    l = m + 1
            else:
                if nums[m] < target <= nums[r - 1]:
                    l = m + 1
                else:
                    r = m
        return False
# leetcode submit region end(Prohibit modification and deletion)
