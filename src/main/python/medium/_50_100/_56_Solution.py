# 56. Merge Intervals
from typing import List


class _56_Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda lst: lst[0])
        ans = []
        for i, lst in enumerate(intervals):
            if i > 0 and ans[-1][1] >= lst[0]:
                previous = ans.pop()
                ans.append([previous[0], max(previous[1], lst[1])])
            else:
                ans.append(lst)
        return ans


if __name__ == '__main__':
    instance = _56_Solution
    assert instance.merge(instance, []) == []
    assert instance.merge(instance, [[1, 4], [2, 3]]) == [[1, 4]]
    assert instance.merge(instance, [[1, 2]]) == [[1, 2]]
    assert instance.merge(instance, [[1, 2], [1, 3], [2, 4]]) == [[1, 4]]
    assert instance.merge(instance, [[1, 2], [2, 3]]) == [[1, 3]]
    assert instance.merge(instance, [[1, 3], [2, 6], [8, 10], [15, 18]]) == [[1, 6], [8, 10], [15, 18]]
