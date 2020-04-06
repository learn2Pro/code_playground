# 417. Pacific Atlantic Water Flow
from typing import List

'''
[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
[]
[[1,2,2,3,5]]
[[1],[2],[2],[3],[5]]
[[1,1],[1,1],[1,1]]
[[11,3,2,4,14,6,13,18,1,4,12,2,4,1,16],[5,11,18,0,15,14,6,17,2,17,19,15,12,3,14],[10,2,5,13,11,11,13,19,11,17,14,18,14,3,11],[14,2,10,7,5,11,6,11,15,11,6,11,12,3,11],[13,1,16,15,8,2,16,10,9,9,10,14,7,15,13],[17,12,4,17,16,5,0,4,10,15,15,15,14,5,18],[9,13,18,4,14,6,7,8,5,5,6,16,13,7,2],[19,9,16,19,16,6,1,11,7,2,12,10,9,18,19],[19,5,19,10,7,18,6,10,7,12,14,8,4,11,16],[13,3,18,9,16,12,1,0,1,14,2,6,1,16,6],[14,1,12,16,7,15,9,19,14,4,16,6,11,15,7],[6,15,19,13,3,2,13,7,19,11,13,16,0,16,16],[1,5,9,7,12,9,2,18,6,12,1,8,1,10,19],[10,11,10,11,3,5,12,0,0,8,15,7,5,13,19],[8,1,17,18,3,6,8,15,0,9,8,8,12,5,18],[8,3,6,12,18,15,10,10,12,19,16,7,17,17,1],[12,13,6,4,12,18,18,9,4,9,13,11,5,3,14],[8,4,12,11,2,2,10,3,11,17,14,2,17,4,7],[8,0,14,0,13,17,11,0,16,13,15,17,4,8,3],[18,15,8,11,18,3,10,18,3,3,15,9,11,15,15]]
'''


class _417_Solution:
    # dfs
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or not matrix[0]: return []
        m, n = len(matrix), len(matrix[0])
        pVisited = [[False] * n for _ in range(m)]
        aVisited = [[False] * n for _ in range(m)]

        def dfs(x: int, y: int, visited, height) -> None:
            if x < 0 or x >= m or y < 0 or y >= n or visited[x][y] or matrix[x][y] < height:
                return
            visited[x][y] = True
            for s0, s1 in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                i, j = x + s0, y + s1
                dfs(i, j, visited, matrix[x][y])

        for i in range(m):
            dfs(i, 0, pVisited, -1)
            dfs(i, n - 1, aVisited, -1)
        for j in range(n):
            dfs(0, j, pVisited, -1)
            dfs(m - 1, j, aVisited, -1)

        ans = []
        for i in range(m):
            for j in range(n):
                if pVisited[i][j] and aVisited[i][j]:
                    ans.append([i, j])
        return ans
    # bfs
    # def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
    #     if not matrix or not matrix[0]: return []
    #     m, n = len(matrix), len(matrix[0])
    #     pQueue = []
    #     aQueue = []
    #     pVisited = [[False] * n for _ in range(m)]
    #     aVisited = [[False] * n for _ in range(m)]
    #     for i in range(m):
    #         pQueue.append((i, 0))
    #         aQueue.append((i, n - 1))
    #         pVisited[i][0] = True
    #         aVisited[i][n - 1] = True
    #     for j in range(n):
    #         pQueue.append((0, j))
    #         aQueue.append((m - 1, j))
    #         pVisited[0][j] = True
    #         aVisited[m - 1][j] = True
    #
    #     def bfs(queue, visited) -> None:
    #         while queue:
    #             (x, y) = queue.pop(0)
    #             for s0, s1 in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
    #                 sx, sy = x + s0, y + s1
    #                 if sx < 0 or sy < 0 or sx >= m or sy >= n or visited[sx][sy] or matrix[sx][sy] < matrix[x][
    #                     y]: continue
    #                 visited[sx][sy] = True
    #                 queue.append((sx, sy))
    #
    #     bfs(pQueue, pVisited)
    #     bfs(aQueue, aVisited)
    #     ans = []
    #     for i in range(m):
    #         for j in range(n):
    #             if pVisited[i][j] and aVisited[i][j]:
    #                 ans.append([i, j])
    #     return ans


if __name__ == '__main__':
    obj = _417_Solution()
    assert obj.pacificAtlantic([[1, 1], [1, 1], [1, 1]]) == [[0, 0], [0, 1], [1, 0], [1, 1], [2, 0], [2, 1]]
    assert obj.pacificAtlantic(
        [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]) == [[0, 4], [1, 3],
                                                                                                   [1, 4], [2, 2],
                                                                                                   [3, 0], [3, 1],
                                                                                                   [4, 0]]
