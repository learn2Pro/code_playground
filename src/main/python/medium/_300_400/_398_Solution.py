# 398. Random Pick Index
import random
from typing import List


class _398_Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums

    def pick(self, target: int) -> int:
        curr, counter = -1, 0
        for i, num in enumerate(self.nums):
            if num == target:
                counter += 1
                rnd = random.randrange(1, counter + 1)
                if rnd == counter: curr = i
        return curr


if __name__ == '__main__':
    obj = _398_Solution([1, 2, 3, 3, 3])
    assert obj.pick(3) == 2
    assert obj.pick(1) == 0
    assert obj.pick(2) == 1
