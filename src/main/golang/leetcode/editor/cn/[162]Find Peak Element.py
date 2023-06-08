from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)
        while l < r:
            mid = (l + r) >> 1
            if mid == 0 or nums[mid - 1] < nums[mid]:
                if mid == len(nums) - 1 or nums[mid] > nums[mid + 1]:
                    return mid
                else:
                    l = mid + 1
            else:
                r = mid
        return l
# leetcode submit region end(Prohibit modification and deletion)
