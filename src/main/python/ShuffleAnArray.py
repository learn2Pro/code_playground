import random
from typing import List


class ShuffleAnArray:

    def __init__(self, nums: List[int]):
        self.origin = nums
        self.n = len(nums)

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        return self.origin

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        return sorted(self.origin, key=lambda x: random.random)

# class ShuffleAnArray:
#
#     def __init__(self, nums: List[int]):
#         self.origin = nums
#         self.current = nums.copy()
#         self.n = len(nums)
#
#     def reset(self) -> List[int]:
#         """
#         Resets the array to its original configuration and return it.
#         """
#         self.current = self.origin.copy()
#         return self.current
#
#     def shuffle(self) -> List[int]:
#         """
#         Returns a random shuffling of the array.
#         """
#         for i in reversed(range(1, self.n)):
#             j = random.randrange(0, i + 1)
#             self.current[i], self.current[j] = self.current[j], self.current[i]
#         return self.current
