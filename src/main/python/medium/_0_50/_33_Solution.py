# 33. Search in Rotated Sorted Array
import math
from typing import List

'''
[4,5,6,7,0,1,2]
0
[]
1
[0]
1
[0]
0
'''


class _33_Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        s, e = l, l + n - 1
        while s <= e:
            mid = (s + e) >> 1
            if nums[mid % n] == target:
                return mid % n
            elif nums[mid % n] < target:
                s = mid + 1
            else:
                e = mid - 1
        return -1


# def search(self, nums: List[int], target: int) -> int:
#     n = len(nums)
#     if n == 0: return -1
#     mid, step = 0, n
#     while step > 0:
#         previous = step
#         if nums[mid] > target:
#             while step > 0 and nums[(mid - step + n) % n] >= nums[mid]: step //= 2
#             mid = (mid - step + n) % n
#             if previous == step: step -= 1
#         elif nums[mid] < target:
#             while step > 0 and nums[(mid + step + n) % n] <= nums[mid]: step //= 2
#             mid = (mid + step + n) % n
#             if previous == step: step -= 1
#         else:
#             return mid
#     return mid if nums[mid] == target else -1


if __name__ == '__main__':
    instance = _33_Solution
    assert instance.search(instance, [2, 3, 4, 5, 6, 7, 8, 1], 8) == 6
    assert instance.search(instance, [1, 3, 5, 7], 7) == 3
    assert instance.search(instance, [2, 3, 4, 5, 6, 7, 8, 1], 1) == 7
    assert instance.search(instance, [1, 3, 5], 5) == 2
    assert instance.search(instance, [1, 3], 0) == -1
    assert instance.search(instance, [2, 3, 4, 5, 6, 7, 8, 1], 7) == 5
    assert instance.search(instance, [], 0) == -1
    assert instance.search(instance, [1], 0) == -1
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 2) == 6
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 1) == 5
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 0) == 4
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 3) == -1
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 4) == 0
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 5) == 1
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 6) == 2
    assert instance.search(instance, [4, 5, 6, 7, 0, 1, 2], 7) == 3
