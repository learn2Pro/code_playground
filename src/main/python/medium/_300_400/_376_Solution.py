# 376. Wiggle Subsequence
from typing import List

'''
[1,7,4,9,2,5]
[1,17,5,10,13,15,10,5,16,8]
[1,2,3,4,5,6,7,8,9]
[1]
[1,2]
[3,2,1]
[1,2,1]
[1,2,3,3,10,2,2,1]
'''
class _376_Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if not nums: return 0
        n = len(nums)
        asc, dsc, a, d = 1, 1, nums[0], nums[0]
        for i in range(1, n):
            t0, t1 = asc, a
            if nums[i] > d:
                asc, a = dsc + 1, nums[i]
            if nums[i] < t1:
                dsc, d = t0 + 1, nums[i]
        return max(asc, dsc)


if __name__ == '__main__':
    obj = _376_Solution()
    assert obj.wiggleMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8]) == 7
    assert obj.wiggleMaxLength([1, 7, 4, 9, 2, 5]) == 6
