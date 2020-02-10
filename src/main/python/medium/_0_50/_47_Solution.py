# 47. Permutations II
from typing import List


class _47_Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        visited = set()

        def track(previous: List[int]) -> None:
            if len(visited) == len(nums):
                ans.append(previous.copy())
                return
            for i, num in enumerate(nums):
                if i > 0 and i - 1 not in visited and nums[i] == nums[i - 1]: continue
                if i in visited: continue
                previous.append(num)
                visited.add(i)
                track(previous)
                previous.pop()
                visited.remove(i)

        track([])
        return ans


if __name__ == '__main__':
    instance = _47_Solution
    assert instance.permuteUnique(instance, [1, 1, 2]) == [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    assert instance.permuteUnique(instance, [1, 1, 1]) == [[1, 1, 1]]
    assert instance.permuteUnique(instance, [1, 1]) == [[1, 1]]
