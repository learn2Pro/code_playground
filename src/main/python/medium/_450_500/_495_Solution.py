# 495. Teemo Attacking
from typing import List


class _495_Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        acc, start, end = 0, 0, -1
        for ts in timeSeries:
            if ts > end:
                acc += end - start + 1
                start = ts
            end = max(ts + duration - 1, end)
        return acc + end - start + 1

    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        if not timeSeries: return 0
        acc = 0
        for i in range(len(timeSeries) - 1):
            acc += min(timeSeries[i + 1] - timeSeries[i], duration)
        return acc + duration

'''
[1,4]
2
[1,2,3,4,5,6,7]
2
[3,9,10]
1
[1,2121,2121,332,100000,1000001212]
10000000
[11,12,13]
10
[]
10
'''
if __name__ == '__main__':
    tar = _495_Solution()
    assert tar.findPoisonedDuration([], 2) == 0
    assert tar.findPoisonedDuration([1], 2) == 2
    assert tar.findPoisonedDuration([1, 4], 2) == 4
    assert tar.findPoisonedDuration([1, 2], 2) == 3
