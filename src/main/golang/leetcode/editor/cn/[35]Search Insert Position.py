from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        def bsearch(t: int):
            lo, hi = 0, len(nums)
            while lo < hi:
                mid = lo + (hi - lo) // 2
                if nums[mid] < t:
                    lo = mid + 1
                else:
                    hi = mid
            return lo

        return bsearch(target)
# leetcode submit region end(Prohibit modification and deletion)
