# 324. Wiggle Sort II
from typing import List


class _324_Solution:
    # use sort
    def wiggleSort(self, nums: List[int]) -> None:
        if not nums: return
        nums.sort()
        half = len(nums[::2]) - 1
        nums[::2], nums[1::2] = nums[half::-1], nums[:half:-1]

    # def wiggleSort(self, nums: List[int]) -> None:
    #     def mergeSort(s: int, e: int) -> None:
    #         if s >= e: return
    #         if s + 1 == e:
    #             nums[s], nums[e] = min(nums[s], nums[e]), max(nums[s], nums[e])
    #             return
    #         mid = (s + e) >> 1
    #         mergeSort(s, mid)
    #         mergeSort(mid + 1, e)
    #         if nums[mid] <= nums[mid + 1]:
    #             nums[mid + 1], nums[mid] = nums[mid], nums[mid + 1]
    #
    #     mergeSort(0, len(nums) - 1)


# def wiggleSort(self, nums: List[int]) -> None:
#     """
#     Do not return anything, modify nums in-place instead.
#     """
#     if not nums: return
#     stack = []
#     i = 0
#     for num in nums:
#         if len(stack) > 0 and (num > stack[-1] or num < stack[-1]):
#             n0, n1 = stack.pop(), num
#             nums[i] = min(n0, n1)
#             nums[i + 1] = max(n0, n1)
#             i += 2
#         else:
#             stack.append(num)

'''
[1,5,1,1,6,4]
[1,2]
[1,2,3]
[1, 3, 2, 2, 3, 1]
[1]
[]
'''
if __name__ == '__main__':
    instance = _324_Solution()
    lst = [1, 5, 1, 1, 6, 4]
    instance.wiggleSort(lst)
    assert lst == [1, 6, 1, 5, 1, 4]
    lst = [1, 3, 2, 2, 3, 1]
    instance.wiggleSort(lst)
    assert lst == [2, 3, 1, 3, 1, 2]
