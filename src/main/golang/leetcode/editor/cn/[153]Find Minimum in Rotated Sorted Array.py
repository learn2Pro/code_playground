from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n-1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        return nums[l]

# leetcode submit region end(Prohibit modification and deletion)
