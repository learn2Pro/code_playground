# 31. Next Permutation
from typing import List


class _31_Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        def swap(i: int, j: int) -> None:
            tmp = nums[j]
            nums[j] = nums[i]
            nums[i] = tmp

        def reverse(s: int) -> None:
            l, r = s, len(nums) - 1
            while l < r:
                swap(l, r)
                l += 1
                r -= 1

        i = len(nums) - 1
        while i > 0 and nums[i - 1] >= nums[i]: i -= 1
        if i > 0:
            for j in range(len(nums) - 1, i - 1, -1):
                if nums[j] > nums[i - 1]: swap(i - 1, j);break;
        reverse(i)
    # def nextPermutation(self, nums: List[int]) -> None:
    #     """
    #     Do not return anything, modify nums in-place instead.
    #     """
    #
    #     def find(i: int) -> int:
    #         min, idx = (0x7fffffff, -1)
    #         for inner in range(i + 1, len(nums)):
    #             if nums[inner] > nums[i] and nums[inner] - nums[i] < min:
    #                 min, idx = nums[inner], inner
    #         return idx
    #
    #     def replaceAndSort(i: int, j: int) -> None:
    #         if j == -1:
    #             nums[max(i, 0):] = sorted(nums[max(i, 0):])
    #         else:
    #             tmp = nums[j]
    #             nums[j] = nums[i]
    #             nums[i] = tmp
    #             nums[i + 1:] = sorted(nums[i + 1:])
    #
    #     replace = -1
    #     inner = len(nums) - 1
    #     while inner >= 0:
    #         replace = find(inner)
    #         if replace != -1: break;
    #         inner -= 1
    #     replaceAndSort(inner, replace)


if __name__ == '__main__':
    item = _31_Solution
    input = [3, 2, 1]
    item.nextPermutation(item, input)
    assert input == [1, 2, 3]
    input = [1, 2, 3]
    item.nextPermutation(item, input)
    assert input == [1, 3, 2]
    input = []
    item.nextPermutation(item, input)
    assert input == []
    input = [1]
    item.nextPermutation(item, input)
    assert input == [1]
    input = [1, 1, 5]
    item.nextPermutation(item, input)
    assert input == [1, 5, 1]
