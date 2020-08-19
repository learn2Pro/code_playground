# 808. Soup Servings
from functools import lru_cache
from math import ceil

'''
25
50
100
1000
3000
4000
5000
10000
89999
999999
9999999
'''


class _808_Solution:
    def soupServings(self, N: int) -> float:
        offset = [(4, 0), (3, 1), (2, 2), (1, 3)]

        @lru_cache(None)
        def dfs(cap0: int, cap1: int) -> float:
            if cap0 != 0.0 and cap1 == 0.0: return 0.0
            if cap0 == 0.0:
                return 0.5 if cap1 == 0.0 else 1.0
            ans = 0.0
            for x, y in offset:
                ans += 0.25 * dfs(max(cap0 - x, 0.0), max(cap1 - y, 0.0))
            return ans

        upper = ceil(N / 25)
        if upper >= 500: return 1.0
        return dfs(upper, upper)


if __name__ == '__main__':
    tar = _808_Solution()
    assert tar.soupServings(25) == 0.625
    assert tar.soupServings(50) == 0.625
