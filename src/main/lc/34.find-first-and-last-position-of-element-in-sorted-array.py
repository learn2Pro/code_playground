#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#
from typing import List
# @lc code=start


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def bleft(t: int):
            l, r = 0, len(nums)
            while l < r:
                mid = (l+r)//2
                if nums[mid] < t:
                    l = mid+1
                else:
                    r = mid
            return l
        start, end = bleft(target), bleft(target+1)
        start = start if start < len(nums) and nums[start] == target else -1
        end = end-1 if end >= 1 and nums[end-1] == target else -1
        return [start, end]


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    assert s.searchRange([5, 7, 7, 8, 8, 10], 8) == [3, 4]
    assert s.searchRange([5, 7, 7, 8, 8, 10], 6) == [-1, -1]
    assert s.searchRange([], 0) == [-1, -1]
    assert s.searchRange([1, 1, 1], 1) == [0, 2]
    assert s.searchRange([1, 1, 1], 0) == [-1, -1]
