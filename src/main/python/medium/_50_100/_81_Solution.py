# 81. Search in Rotated Sorted Array II
from typing import List

'''
[2,5,6,0,0,1,2]
0
[]
0
[0,1,2]
1
[1,2,0]
1
[2,0,1]
3
[0,0,0,0]
0
[1,1,1,1]
2
[1,3,1,1,1]
3
'''


class _80_Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l, r = 0, len(nums) - 1

        while l <= r:
            # while (l < r && nums[l] == nums[l + 1]) l++; // skip duplicates from the left
            # while (r > l && nums[r] == nums[r - 1]) r--; // skip duplicates from the right

            while (l < r and nums[l] == nums[l + 1]):
                l += 1

            while (l < r and nums[r] == nums[r - 1]):
                r -= 1
            mid = (l + r) >> 1
            if nums[mid] == target:
                return True

            if nums[mid] > nums[r]:
                if nums[mid] > target and target >= nums[l]:
                    r = mid - 1
                else:
                    l = mid + 1
            elif nums[mid] < nums[l]:
                if nums[mid] < target and target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1

        return False
# def search(self, nums: List[int], target: int) -> bool:
#         n = len(nums)
#         if n == 0: return False
#         lo, hi = 0, n
#         while lo < n - 1 and nums[lo] <= nums[lo + 1]: lo += 1
#         hi = lo + 1
#         lo += n
#         while hi <= lo:
#             mid = (lo + hi) >> 1
#             if target == nums[mid % n]:
#                 return True
#             elif nums[mid % n] < target:
#                 hi = mid + 1
#             else:
#                 lo = mid - 1
#         return False


if __name__ == '__main__':
    instance = _80_Solution
    assert instance.search(instance, [1, 2, 2, 5, 6, 0, 0], 0)
    assert instance.search(instance, [1, 1, 1, 1, 1], 1)
    assert instance.search(instance, [1, 3, 1, 1, 1], 3)
    assert instance.search(instance, [0, 0, 1, 2, 2, 5, 6], 0)
    assert instance.search(instance, [0, 1, 2, 2, 5, 6, 0], 0)
    assert not instance.search(instance, [], 0)
    assert instance.search(instance, [2, 2, 5, 6, 0, 0, 1], 0)
    assert instance.search(instance, [2, 5, 6, 0, 0, 1, 2], 0)
    assert instance.search(instance, [5, 6, 0, 0, 1, 2, 2], 0)
    assert instance.search(instance, [6, 0, 0, 1, 2, 2, 5], 0)
    assert instance.search(instance, [2, 5, 6, 0, 0, 1, 2], 0)
    assert not instance.search(instance, [0, 0, 1, 2, 2, 5, 6], 3)
