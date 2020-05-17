# 477. Total Hamming Distance
from typing import List

'''
[4,14,2]
[]
[1]
[1,2,3,4,5,6]'''


class _477_Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        if not nums: return 0

        def dis(fst: int, snd: int) -> int:
            xor, distance = fst ^ snd, 0
            while xor:
                distance += 1
                xor = xor & (xor - 1)
            return distance

        _xor, _or, distance = nums[0], 0, 0
        for i in range(1, len(nums)):
            distance += dis(_xor, nums[i]) + i * dis(_or, nums[i])
            _xor ^= nums[i]
            _or |= nums[i]
        return distance

    def totalHammingDistance(self, nums: List[int]) -> int:
        if not nums: return 0
        distance = 0
        for i in range(32):
            bits = 0
            for num in nums:
                bits += (num >> i) & 1
            distance += bits * (len(nums) - bits)
        return distance

    def totalHammingDistance(self, nums: List[int]):
        # for x in map('{:032b}'.format, nums):
        #     print(x)
        # for z in zip(*map('{:032b}'.format, nums)):
        #     print(z)
        return sum(b.count('0') * b.count('1') for b in zip(*map('{:032b}'.format, nums)))


if __name__ == '__main__':
    obj = _477_Solution()
    assert obj.totalHammingDistance([4, 14, 2]) == 6
