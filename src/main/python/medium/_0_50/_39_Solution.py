# 39. Combination Sum
from typing import List


class _39_Solution:
    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     candidates.sort()
    #     mini = candidates[0]
    #     res = []
    #
    #     def rec_find(target, start, end, path):
    #         if target == 0:
    #             res.append(path)
    #         for i in range(start, end + 1):
    #             cur = candidates[i]
    #             if cur > target: break
    #             rem = target - cur
    #             if rem and rem < mini: continue
    #             rec_find(rem, i, end, path + [cur])
    #
    #     rec_find(target, 0, len(candidates) - 1, [])
    #     return res

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        def backtrack(previous: List[int], num: int, idx: int) -> None:
            if num == 0:
                ans.append(previous.copy())
                return
            for i in range(idx, len(candidates)):
                x = candidates[i]
                if x > num: continue
                previous.append(x)
                backtrack(previous, num - x, i)
                previous.pop()

        backtrack([], target, 0)
        return ans


if __name__ == '__main__':
    instance = _39_Solution
    assert instance.combinationSum(instance, [3, 3, 3], 6) == [[3, 3]]
    assert instance.combinationSum(instance, [3, 3, 3], 9) == [[3, 3, 3]]
    assert instance.combinationSum(instance, [2, 2], 4) == [[2, 2]]
    assert instance.combinationSum(instance, [1], 1) == [[1]]
    assert instance.combinationSum(instance, [2, 2], 3) == []
    assert instance.combinationSum(instance, [], 8) == []
    assert instance.combinationSum(instance, [2, 3, 5], 8) == [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    assert instance.combinationSum(instance, [2, 3, 6, 7], 7) == [[2, 2, 3], [7]]
