# 260. Single Number III
from typing import List


class _260_Solution:
    # xor
    def singleNumber(self, nums: List[int]) -> List[int]:
        xor = 0
        for num in nums:
            xor ^= num
        mask = -xor & xor
        num0, num1 = 0, 0
        for num in nums:
            if num & mask == 0:
                num0 ^= num
            else:
                num1 ^= num
        return [num0, num1]


if __name__ == '__main__':
    instance = _260_Solution
    assert instance.singleNumber(instance, [1, 2, 1, 3, 2, 5]) == [3, 5]
# map
# def singleNumber(self, nums: List[int]) -> List[int]:
#     if len(nums) < 2: return []
#     container = {}
#     for num in nums:
#         if num in container: del container[num]
#         container[num] = 1
#     return list(container.keys())
