# 421. Maximum XOR of Two Numbers in an Array
from typing import List


class _421_Solution:
    class Trie:
        def __init__(self):
            self.children = [None] * 2

    # use trie
    def findMaximumXOR(self, nums: List[int]) -> int:
        if not nums: return 0
        n = len(nums)
        root, maximal = self.Trie(), 0
        for num in nums:
            current, complement = root, root
            value = 0
            for i in reversed(range(32)):
                bit = (num >> i) & 1
                if not current.children[bit]: current.children[bit] = self.Trie()
                current = current.children[bit]
                if complement.children[bit ^ 1]:
                    complement = complement.children[bit ^ 1]
                    value += 1 << i
                else:
                    complement = complement.children[bit]
            maximal = max(maximal, value)
        return maximal

    # use hashmap
    def findMaximumXOR(self, nums: List[int]) -> int:
        if not nums: return 0
        maximal, mask = 0, 0
        for i in range(32)[::-1]:
            mask |= 1 << i
            prefix = set()
            for num in nums:
                prefix.add(mask & num)
            for p in prefix:
                if (maximal | 1 << i) ^ p in prefix:
                    maximal |= 1 << i
                    break
        return maximal

    # 6-line
    def findMaximumXOR(self, nums: List[int]) -> int:
        answer = 0
        for i in range(32)[::-1]:
            answer <<= i
            prefixes = {num >> i for num in nums}
            answer += any(answer^1 ^ p in prefixes for p in prefixes)
        return answer


if __name__ == '__main__':
    obj = _421_Solution()
    assert obj.findMaximumXOR([3, 10, 5, 25, 2, 8]) == 28
