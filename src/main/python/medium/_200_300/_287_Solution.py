# 287. Find the Duplicate Number
from typing import List


class _287_Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        if not nums: return -1
        fast, slow = nums[nums[0]], nums[0]
        while fast != slow:
            fast = nums[nums[fast]]
            slow = nums[slow]
        fast = 0
        while fast != slow:
            fast = nums[fast]
            slow = nums[slow]
        return slow
    # def findDuplicate(self, nums: List[int]) -> int:
    #     if not nums: return -1
    #     idx, n = 0, len(nums)
    #     while idx < n:
    #         if idx < 0:
    #             idx += 1
    #         else:
    #             next = nums[idx]
    #             nums[idx] = -1
    #             if nums[next] < 0:
    #                 return next
    #             else:
    #                 idx = next
    #     return -1


if __name__ == '__main__':
    instance = _287_Solution()
    assert instance.findDuplicate([1, 3, 4, 2, 2]) == 2
    assert instance.findDuplicate([1, 2, 1]) == 1
    assert instance.findDuplicate([]) == -1
    assert instance.findDuplicate([1, 1]) == 1
    assert instance.findDuplicate([3, 1, 3, 4, 2]) == 3
