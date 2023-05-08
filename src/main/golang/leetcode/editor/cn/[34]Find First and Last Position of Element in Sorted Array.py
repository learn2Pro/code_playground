from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        def bsearch(num: int) -> int:
            lo, hi = 0, n
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] < num:
                    lo = mid + 1
                else:
                    hi = mid
            return lo

        left = bsearch(target)
        if left == len(nums) or nums[left] != target:
            return [-1, -1]
        right = bsearch(target + 1) - 1
        return [left, right]
# leetcode submit region end(Prohibit modification and deletion)
