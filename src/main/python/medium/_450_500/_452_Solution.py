# 452. Minimum Number of Arrows to Burst Balloons
from typing import List


class _452_Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if not points or not points[0]: return 0
        n, ans = len(points), 0
        end = -0xfffffff
        points.sort(key=lambda lst: lst[1])
        for point in points:
            if point[0] > end:
                end = points[1]
                ans += 1
        return ans
