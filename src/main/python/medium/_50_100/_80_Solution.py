# 80. Remove Duplicates from Sorted Array II
from typing import List


class _80_Solution:

    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return len(nums)
        current, index, count = nums[0], 1, 1
        for i in range(1, len(nums)):
            if nums[i] == current:
                if count < 2:
                    nums[index] = current
                    index += 1
                    count += 1
            else:
                nums[index] = nums[i]
                current = nums[index]
                index += 1
                count = 1
        return index
    # def removeDuplicates(self, nums: List[int]) -> int:
    #     size = len(nums)
    #     if size == 0: return 0
    #     count, current, i = 0, nums[0], 0
    #
    #     while i < size:
    #         if current > nums[i]:
    #             break
    #         elif current == nums[i]:
    #             count += 1
    #             if count > 2:
    #                 nums.pop(i)
    #                 nums.append(current - 1)
    #                 i -= 1
    #         else:
    #             count = 1
    #             current = nums[i]
    #         i += 1
    #
    #     return i


if __name__ == '__main__':
    instance = _80_Solution
    assert instance.removeDuplicates(instance, [1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4]) == 7
    assert instance.removeDuplicates(instance, [0, 0, 0, 0]) == 2
    assert instance.removeDuplicates(instance, [1, 1, 1, 1, 1]) == 2
    assert instance.removeDuplicates(instance, [1, 1, 1, 1]) == 2
    assert instance.removeDuplicates(instance, [1, 1, 1, 2, 2, 3]) == 5
    assert instance.removeDuplicates(instance, []) == 0
    assert instance.removeDuplicates(instance, [1]) == 1
    assert instance.removeDuplicates(instance, [1, 1]) == 2
    assert instance.removeDuplicates(instance, [1, 1, 1]) == 2
