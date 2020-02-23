# 137. Single Number II
from typing import List

'''
[2,2,3,2]
[0,1,0,1,0,1,99]
[1]
'''


class _137_Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # ternary
        num0 = num1 = 0
        for num in nums:
            num1 ^= num & num0
            num0 ^= num
            carry = num1 & num0
            num1 ^= carry
            num0 ^= carry
        return num0


if __name__ == '__main__':
    instance = _137_Solution
    assert instance.singleNumber(instance, [3, 3, 3, 1]) == 1
    assert instance.singleNumber(instance, [3, 3, 3, 2, 1, 2, 2]) == 1
