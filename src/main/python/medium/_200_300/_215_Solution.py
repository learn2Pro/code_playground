# 215. Kth Largest Element in an Array
import heapq
from typing import List

'''
[3,2,1,5,6,4]
2
[3,2,3,1,2,4,5,5,6]
4
[3,2,1]
3
[1,1,1,1,1]
2
[4,3,2,1]
1
[1]
1
[2]
1
[1,2,3]
2
'''


class _215_Solution:
    # heap
    # def findKthLargest(self, nums: List[int], k: int) -> int:
    #     heap = []
    #     for num in nums:
    #         heapq.heappush(heap, num)
    #         if len(heap) > k: heapq.heappop(heap)
    #     return heapq.heappop(heap)

    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[k - 1]

    # sort
    # def findKthLargest(self, nums: List[int], k: int) -> int:
    #     nums.sort()
    #     return nums[-k]
    # quick selection
    # def findKthLargest(self, nums: List[int], k: int) -> int:
    #
    #     def swap(i: int, j: int):
    #         tmp = nums[i]
    #         nums[i] = nums[j]
    #         nums[j] = tmp
    #
    #     def partition(start: int, end: int) -> int:
    #         pivot = nums[start]
    #         lo, hi = start + 1, end
    #         while lo <= hi:
    #             while lo <= end and nums[lo] < pivot: lo += 1
    #             while hi > start and nums[hi] >= pivot: hi -= 1
    #             if lo <= hi: swap(lo, hi)
    #         swap(start, lo - 1)
    #         return lo - 1
    #
    #     def partialSort(start: int, end: int, k: int) -> int:
    #         n = end - start + 1
    #         left = start + n - k
    #         pivot = partition(start, end)
    #         if pivot == left:
    #             return nums[pivot]
    #         elif pivot < left:
    #             return partialSort(pivot + 1, end, k)
    #         else:
    #             return partialSort(0, pivot - 1, pivot - left)
    #
    #     return partialSort(0, len(nums) - 1, k)


if __name__ == '__main__':
    instance = _215_Solution
    assert instance.findKthLargest(instance, [3, 2, 1, 5, 6, 4], 2) == 5
    assert instance.findKthLargest(instance, [2, 1], 1) == 2
    assert instance.findKthLargest(instance, [1, 2, 3], 3) == 1
    assert instance.findKthLargest(instance, [3, 2, 1], 3) == 1
    assert instance.findKthLargest(instance, [3, 2, 3, 1, 2, 4, 5, 5, 6], 4) == 4
