from functools import reduce
from typing import List

''''
[1,1,2,3,3,4,4,8,8]
[1]
[1,2,2]
[1,1,3]
[1,1,2,3,3]
[1,1,2,2,3,3,4]
'''
class _540_Solution:
    # xor
    def singleNonDuplicate(self, nums: List[int]) -> int:
        return reduce(lambda fst, snd: fst ^ snd, nums)

    # sort traversal
    def singleNonDuplicate(self, nums: List[int]) -> int:
        ans = nums[0]
        for i in range(1, len(nums), 2):
            if nums[i] != ans:
                return ans
            ans = nums[i + 1]
        return ans

    # binary search
    def singleNonDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        l, r = 0, size - 1
        while l < r:
            mid = (l + r) >> 1
            if (size - mid - 1) % 2 == 1 and nums[mid] == nums[mid - 1]:
                l = mid + 1
            elif (size - mid - 1) % 2 == 0 and nums[mid] == nums[mid + 1]:
                l = mid + 1
            else:
                r = mid
        return nums[l]
