# 216. Combination Sum III
from typing import List


class _216_Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        ans = []

        def backtrack(previous: List[int], target: int) -> None:
            if len(previous) == k:
                if target == 0:
                    ans.append(previous.copy())
                return
            start = 1 if not previous else previous[-1] + 1
            for num in range(start, 10):
                if num > target: continue
                previous.append(num)
                backtrack(previous, target - num)
                previous.pop()

        backtrack([], n)
        return ans


if __name__ == '__main__':
    instance = _216_Solution
    assert instance.combinationSum3(instance, 3, 7) == [[1, 2, 4]]
    assert instance.combinationSum3(instance, 3, 9) == [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
