# 75. Sort Colors
from typing import List


class _75_Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        def swap(i, j):
            tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp

        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            while l < r and nums[l] == 0: l += 1
            while l < r and nums[r] != 0: r -= 1
            swap(l, r)
        r = n - 1
        while l < r:
            while l < r and nums[l] == 1: l += 1
            while l < r and nums[r] == 2: r -= 1
            swap(l, r)


if __name__ == '__main__':
    instance = _75_Solution
    instance.sortColors(instance, [2, 0, 2, 1, 1, 0]) == [0, 0, 1, 1, 2, 2]
