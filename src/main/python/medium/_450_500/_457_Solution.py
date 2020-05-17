# 457. Circular Array Loop
from typing import List

'''
[2,-1,1,2,2]
[-1,2]
[-2,1,-1,-2,-2]
[1,1,1]
[2,2,2]
[2]
[]
[2,-1,1,-2,-2]
'''


class _457_Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        for i, num in enumerate(nums):
            mark = str(i)
            while (type(nums[i]) == int) and (num * nums[i] > 0) and (nums[i] % len(nums) != 0):
                jump = nums[i]
                nums[i] = mark
                i = (i + jump) % len(nums)
            if nums[i] == mark:
                return True

        return False


if __name__ == '__main__':
    obj = _457_Solution()
    assert obj.circularArrayLoop([-1, 1, 2]) == True
    assert obj.circularArrayLoop([3, 1, 2]) == True
    assert obj.circularArrayLoop([2, -1, 1, -2, -2]) == False
    assert obj.circularArrayLoop([2, -1, 1, 2, 2]) == True
