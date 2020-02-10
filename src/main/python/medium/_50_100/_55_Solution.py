# 55. Jump Game
from typing import List

'''
[2,3,1,1,4]
[3,2,1,0,4]
[]
[1]
[1,2]
[1,1,0,3]'''


class _55_Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 0: return False
        step = nums[0]
        for i in range(1, len(nums)):
            if step >= i:
                step = max(step, nums[i] + i)
        return step >= len(nums) - 1


if __name__ == '__main__':
    instance = _55_Solution
    assert instance.canJump(instance, [[2, 3, 1, 1, 4]]) == True
    assert instance.canJump(instance, [3, 2, 1, 0, 4]) == False
