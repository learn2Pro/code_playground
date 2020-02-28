# 200. Number of Islands
from typing import List

'''
[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
[]
[[]]
[["1"]]
[["1"],["0"],["1"]]
[["1","0","1"]]
[["0"]]
[["1","1","1"],["0","1","0"],["1","1","1"]]
'''


class _200_Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]: return 0
        visited = set()
        m, n = len(grid), len(grid[0])

        def bfs(x: int, y: int) -> None:
            queue = []
            queue.append((x, y))
            while queue:
                (px, py) = queue.pop(0)
                if px + 1 < m and grid[px + 1][py] != '0' and (px + 1, py) not in visited:
                    queue.append((px + 1, py))
                    visited.add((px + 1, py))
                if py + 1 < n and grid[px][py + 1] != '0' and (px, py + 1) not in visited:
                    queue.append((px, py + 1))
                    visited.add((px, py + 1))
                if px - 1 >= 0 and grid[px - 1][py] != '0' and (px - 1, py) not in visited:
                    queue.append((px - 1, py))
                    visited.add((px - 1, py))
                if py - 1 >= 0 and grid[px][py - 1] != '0' and (px, py - 1) not in visited:
                    queue.append((px, py - 1))
                    visited.add((px, py - 1))

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0' or (i, j) in visited: continue
                visited.add((i, j))
                bfs(i, j)
                ans += 1
        return ans
