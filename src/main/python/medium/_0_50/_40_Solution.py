# 40. Combination Sum II
from typing import List

'''
[10,1,2,7,6,1,5]
8
[]
1
[2,2]
4
[3,3,3]
6
[3,3,3]
9
[2,5,2,1,2]
5
[4,2,5,2,5,3,1,5,2,2]
9

[[1,1,6],[1,2,5],[1,7],[2,6]]
[]
[[2,2]]
[[3,3]]
[[3,3,3]]
[[1,2,2],[5]]
'''


class _40_Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []

        def backTrack(previous: List[int], idx: int, num: int) -> None:
            if num < 0: return
            if num == 0:
                ans.append(previous.copy())
                return
            for i in range(idx, len(candidates)):
                if i > idx and candidates[i] == candidates[i - 1]: continue
                if candidates[i] > target: break
                previous.append(candidates[i])
                backTrack(previous, i + 1, num - candidates[i])
                previous.pop()

        backTrack([], 0, target)
        return ans


if __name__ == '__main__':
    instance = _40_Solution
    assert instance.combinationSum2(instance, [4, 2, 5, 2, 5, 3, 1, 5, 2, 2], 9) == [[1,2,2,2,2],[1,2,2,4],[1,3,5],[2,2,2,3],[2,2,5],[2,3,4],[4,5]]
    assert instance.combinationSum2(instance, [3, 3, 3], 6) == [[3, 3]]
    assert instance.combinationSum2(instance, [10, 1, 2, 7, 6, 1, 5], 8) == [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    assert instance.combinationSum2(instance, [3, 3, 3], 9) == [[3, 3, 3]]
