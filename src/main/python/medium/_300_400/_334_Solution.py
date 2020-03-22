# 334. Increasing Triplet Subsequence
from typing import List

'''
[1,2,3,4,5]
[5,4,3,2,1]
[1]
[1,2]
[1,2,3]
[1,3,2]
[1,3,1,2,1]
[1,10,5,6]
'''


class _334_Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 3: return False
        smaller = bigger = 0x7fffffff
        for num in nums:
            if num <= smaller:
                smaller = num
            elif num <= bigger:
                bigger = num
            else:
                return True
        return False


if __name__ == '__main__':
    instance = _334_Solution()
    assert instance.increasingTriplet([2, 1, 3, 1, 5])
    assert not instance.increasingTriplet([5, 4, 3, 2, 1])
    assert instance.increasingTriplet([1, 2, 3, 4, 5])
