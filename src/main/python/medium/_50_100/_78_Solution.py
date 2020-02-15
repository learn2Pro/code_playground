# 78. Subsets
from typing import List


class _78_Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        ans.append([])
        n = len(nums)

        def track(previous: List[int], start: int) -> None:
            if start >= n:
                return
            for i in range(start, n):
                previous.append(nums[i])
                ans.append(previous.copy())
                track(previous, i + 1)
                previous.pop()

        track([], 0)
        return ans


if __name__ == '__main__':
    instance = _78_Solution
    assert instance.subsets(instance, [1, 2, 3]) == [[3], [1], [2], [1, 2, 3], [1, 3], [2, 3], [1, 2], []]
    assert instance.subsets(instance, [1]) == [[1], []]
