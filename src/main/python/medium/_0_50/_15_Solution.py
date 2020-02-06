# 15. 3Sum
import bisect
import collections
from typing import List


class _15_Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        counts = collections.defaultdict(int)
        for i in nums:
            if i in counts:
                counts[i] += 1
            else:
                counts[i] = 1
        nums = sorted(counts)
        for i, num in enumerate(nums):
            if counts[num] > 1:
                if num == 0:
                    if counts[num] > 2:
                        ans.append([num, num, num])
                else:
                    if -num * 2 in nums:
                        ans.append([num, num, -2 * num])
            if num < 0:
                twosum = -num
                left = bisect.bisect_left(nums, (twosum - nums[-1]), i + 1)
                for i in nums[left:bisect.bisect_right(nums, (twosum // 2), left)]:
                    j = twosum - i
                    if j in counts and j != i:
                        ans.append([num, i, j])
        return ans

    # def threeSum(self, nums: List[int]) -> List[List[int]]:
    #     nums.sort()
    #     ans = []
    #     for i in range(0, len(nums) - 2):
    #         if nums[i] > 0: break
    #         if i >= 1 and nums[i] == nums[i - 1]: continue
    #
    #         l, r = i + 1, len(nums) - 1
    #         while l < r:
    #             target = nums[l] + nums[i] + nums[r]
    #             if target > 0:
    #                 r -= 1
    #             elif target < 0:
    #                 l += 1
    #             else:
    #                 ans.append([nums[i], nums[l], nums[r]])
    #                 while l < len(nums)-1 and nums[l + 1] == nums[l]: l += 1;
    #                 while r >= 1 and nums[r - 1] == nums[r]: r -= 1;
    #                 l += 1
    #                 r -= 1
    #
    #     return ans


# def threeSum(self, nums: List[int]) -> List[List[int]]:
#     distinct = set()
#     map = set()
#     for i in range(len(nums)):
#         target = -nums[i]
#         for j in range(i + 1, len(nums)):
#             curr = nums[j]
#             if target - curr in map:
#                 distinct.add(tuple(sorted([nums[i], nums[j], target - curr])))
#                 map.remove(target - curr)
#             else:
#                 map.add(curr)
#         map.clear()
#     ans = []
#     for ele in distinct:
#         ans.append(list(ele))
#     return ans


if __name__ == '__main__':
    instance = _15_Solution
    assert instance.threeSum(instance, [-1, 0, 1, 2, -1, -4]) == [[-1, -1, 2], [-1, 0, 1]]
    assert instance.threeSum(instance, [-4, 8, 92, 1, 3, 0]) == [[-4, 1, 3]]
    assert instance.threeSum(instance, []) == []
