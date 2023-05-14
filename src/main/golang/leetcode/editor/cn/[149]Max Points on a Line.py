from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        from collections import defaultdict
        from math import gcd
        n = len(points)
        ans = 0
        for i in range(n):
            cnt = defaultdict(int)
            for j in range(i + 1, n):
                dx, dy = points[i][0] - points[j][0], points[i][1] - points[j][1]
                if dx == 0:
                    dy = 1
                elif dy == 0:
                    dx = 1
                else:
                    if dy < 0:
                        dx, dy = -dx, -dy
                    g = gcd(dx, dy)
                    dx //= g
                    dy //= g
                cnt[dy + dx * 20001] += 1
            ans = max(ans,  1 + max(cnt.values() if cnt.values() else [0]))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
