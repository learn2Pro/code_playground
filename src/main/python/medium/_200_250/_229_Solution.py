# 229. Majority Element II
from typing import List

'''
[3,2,3]
[]
[1,1,1,3,3,2,2,2]
[1]
[1,1]
[1,1,1]
[1,2,3]
[1,2,2,3,2,1,1,3]
[1,1,2]
[1,2]
'''


class _229_Solution:
    # major vote algorithm
    def majorityElement(self, nums: List[int]) -> List[int]:
        if not nums: return []
        candidate0, candidate1 = 0, 1
        count0 = count1 = 0
        for num in nums:
            if num == candidate0:
                count0 += 1
                candidate0 = num
            elif num == candidate1:
                count1 += 1
                candidate1 = num
            elif count0 == 0:
                candidate0 = num
                count0 += 1
            elif count1 == 0:
                candidate1 = num
                count1 += 1
            else:
                count0 -= 1
                count1 -= 1
        set = {candidate0, candidate1}
        return [i for i in set if nums.count(i) > len(nums) / 3]
    # use counter
    # def majorityElement(self, nums: List[int]) -> List[int]:
    #     if not nums: return []
    #     ctr = collections.Counter()
    #     for num in nums:
    #         ctr[num] += 1
    #         if len(ctr) >= 3:
    #             ctr -= collections.Counter(set(ctr))
    #
    #     return [i for i in ctr if nums.count(i) > len(nums) / 3]


if __name__ == '__main__':
    instance = _229_Solution
    assert instance.majorityElement(instance, [1, 2, 2, 3, 2, 1, 1, 3]) == [1, 2]
    assert instance.majorityElement(instance, [1, 1]) == [1]
    assert instance.majorityElement(instance, [1, 1, 1, 3, 3, 2, 2, 2]) == [1, 2]
    assert instance.majorityElement(instance, []) == []
    assert instance.majorityElement(instance, [1, 1, 2, 1]) == [1]
