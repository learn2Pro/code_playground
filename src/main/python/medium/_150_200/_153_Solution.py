# 153. Find Minimum in Rotated Sorted Array
from typing import List


class _153_Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        lo, hi = 0, n - 1
        while lo < hi:
            mid = (lo + hi) >> 1
            if nums[mid] > nums[-1]:
                lo = mid + 1
            else:
                hi = mid
        return nums[lo]
