# 162. Find Peak Element
from typing import List


class _162_Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        lo, hi = 0, n - 1

        def get(i: int) -> int:
            if i == -1 or i == n:
                return -0xffffffff
            else:
                return nums[i]

        while lo <= hi:
            mid = (lo + hi) >> 1
            if get(mid - 1) < get(mid) > get(mid + 1):
                return mid
            elif get(mid - 1) > get(mid) > get(mid + 1):
                hi = mid - 1
            else:
                lo = mid + 1
        return lo


if __name__ == '__main__':
    instance = _162_Solution
    assert instance.findPeakElement(instance, [1, 2]) == 1
    assert instance.findPeakElement(instance, [2, 1]) == 0
    assert instance.findPeakElement(instance, [1]) == 0
    assert instance.findPeakElement(instance, [1, 2, 1, 3, 5, 6, 4]) == 5
    assert instance.findPeakElement(instance, [1, 2, 3, 1]) == 2
