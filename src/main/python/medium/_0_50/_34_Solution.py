# 34. Find First and Last Position of Element in Sorted Array
from typing import List


class _34_Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lo, hi = 0, len(nums) - 1
        ans = [-1, -1]
        if len(nums) == 0: return ans
        while lo < hi:
            mid = (lo + hi) >> 1
            if nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid
        if nums[lo] != target: return ans
        ans[0] = lo
        hi = len(nums) - 1
        while lo < hi:
            mid = ((lo + hi) >> 1) + 1
            if nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid
        ans[1] = hi
        return ans
    # def searchRange(self, nums: List[int], target: int) -> List[int]:
    #     l, r = 0, len(nums) - 1
    #     while l <= r:
    #         mid = (l + r) >> 1
    #         if nums[mid] == target:
    #             p0, p1 = mid, mid
    #             while p0 >= 0 and nums[p0] == target: p0 -= 1
    #             while p1 < len(nums) and nums[p1] == target: p1 += 1
    #             return [p0 + 1, p1 - 1]
    #         elif nums[mid] < target:
    #             l = mid + 1
    #         else:
    #             r = mid - 1
    #     return [-1, -1]


if __name__ == '__main__':
    instance = _34_Solution
    assert instance.searchRange(instance, [1, 3, 5], 3) == [1, 1]
    assert instance.searchRange(instance, [], 8) == [-1, -1]
    assert instance.searchRange(instance, [0, 0], 0) == [0, 1]
    assert instance.searchRange(instance, [2, 2, 2], 2) == [0, 2]
    assert instance.searchRange(instance, [1, 1], 1) == [0, 1]
    assert instance.searchRange(instance, [1, 3, 5, 7], 5) == [2, 2]
    assert instance.searchRange(instance, [5, 7, 7, 8, 8, 10], 8) == [3, 4]
    assert instance.searchRange(instance, [5, 7, 7, 8, 8, 10], 6) == [-1, -1]
