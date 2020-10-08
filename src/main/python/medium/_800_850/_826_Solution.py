# 826. Most Profit Assigning Work
import bisect
from typing import List


class _826_Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        sorted_tuple = [(0, 0)] + sorted(zip(difficulty, profit), key=lambda t: t[0])
        for i in range(1, len(sorted_tuple)):
            sorted_tuple[i] = (sorted_tuple[i][0], max(sorted_tuple[i - 1][1], sorted_tuple[i][1]))
        ans = 0
        sorted_difficulty = [x for x, y in sorted_tuple]
        for w in worker:
            if w >= 0:
                index = bisect.bisect_right(sorted_difficulty, max(0, w))
                ans += sorted_tuple[index - 1][1]
        return ans

    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        jobs = sorted(zip(difficulty, profit),key=lambda t:t[0])
        ans = i = best = 0
        for w in sorted(worker):
            while i < len(jobs) and w >= jobs[i][0]:
                best = max(best, jobs[i][1])
                i += 1
            ans += best
        return ans


'''
[2,4,6,8,10]
[10,20,30,40,50]
[4,5,6,7]
[0,0,0]
[10,20,30]
[1,-1,2]
[0,0,0]
[10,30,30]
[1,0,1]
[1,10,30]
[100,10,20]
[3,20,50]
[]
[]
[]
[1]
[-1]
[1]
'''
if __name__ == '__main__':
    obj = _826_Solution()
    assert obj.maxProfitAssignment([1], [-1], [1]) == 0
    assert obj.maxProfitAssignment([2, 4, 6, 8, 10], [10, 20, 30, 40, 50], [4, 5, 6, 7]) == 100
