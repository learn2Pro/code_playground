# 46. Permutations
import itertools
from typing import List

'''
[1,2,3]
[1]
[2,2]
[5,4,3]
[8,7,6,5]
'''
class _46_Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # itertools.permutations(nums)
        ans = []
        visited = set()

        def track(previous: List[int]) -> None:
            if len(nums) == len(visited):
                ans.append(previous.copy())
                return
            for num in nums:
                if num in visited: continue
                visited.add(num)
                previous.append(num)
                track(previous)
                previous.pop()
                visited.remove(num)

        track([])
        return ans


if __name__ == '__main__':
    instance = _46_Solution
    assert instance.permute(instance, [1, 2, 3]) == [
        [1, 2, 3],
        [1, 3, 2],
        [2, 1, 3],
        [2, 3, 1],
        [3, 1, 2],
        [3, 2, 1]
    ]
    assert instance.permute(instance, [1]) == [[1]]
