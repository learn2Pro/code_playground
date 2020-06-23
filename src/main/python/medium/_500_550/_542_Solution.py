# 542. 01 Matrix
from typing import List

'''
[[0,0,0],[0,1,0],[0,0,0]]
[[1,1,1],[0,1,0],[1,1,1]]
[[0,0,0],[0,1,0],[1,1,1]]
[[]]
[[1],[0],[1]]
[[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1]]
'''


class _542_Solution:
    # dfs
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        visited = set()
        if not matrix or not matrix[0]: return matrix
        m, n = len(matrix), len(matrix[0])

        def dfs(x, y):
            if matrix[x][y] <= 0:
                return -matrix[x][y]
            maximal = -0x7fffffff
            for offset0, offset1 in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                if x + offset0 < 0 or x + offset0 >= m or y + offset1 < 0 or y + offset1 >= n or (
                        x + offset0, y + offset1) in visited: continue
                visited.add((x + offset0, y + offset1))
                maximal = max(maximal, -1 - dfs(x + offset0, y + offset1))
                visited.remove((x + offset0, y + offset1))
            if matrix[x][y] <= 0:
                matrix[x][y] = max(matrix[x][y], maximal)
            elif maximal != -0x7fffffff:
                matrix[x][y] = maximal
            return -matrix[x][y]

        for i in range(m):
            for j in range(n):
                visited.add((i, j))
                dfs(i, j)
                visited.remove((i, j))
        for i in range(m):
            for j in range(n):
                matrix[i][j] *= -1
        return matrix

    # bfs
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:

        visited = set()
        if not matrix or not matrix[0]: return matrix
        m, n = len(matrix), len(matrix[0])

        def bfs(x, y):
            queue = [(x, y, 0)]
            while queue:
                cx, cy, d = queue.pop(0)
                if matrix[cx][cy] == 0:
                    return d
                for offset0, offset1 in [(0, -1), (0, 1), (-1, 0), (1, 0)]:
                    if cx + offset0 < 0 or cx + offset0 >= m or cy + offset1 < 0 or cy + offset1 >= n or (
                            cx + offset0, cy + offset1) in visited: continue
                    queue.append((cx + offset0, cy + offset1, d + 1))

        for i in range(m):
            for j in range(n):
                matrix[i][j] = bfs(i, j)
                visited.clear()
        return matrix

    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or not matrix[0]: return matrix
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if not matrix[i][j]: continue
                top = matrix[i - 1][j] if i else 0x7fffffff
                left = matrix[i][j - 1] if j else 0x7fffffff
                matrix[i][j] = min(top, left) + 1
        for i in reversed(range(m)):
            for j in reversed(range(n)):
                if not matrix[i][j]: continue
                down = matrix[i + 1][j] if i < m - 1 else 0x7fffffff
                right = matrix[i][j + 1] if j < n - 1 else 0x7fffffff
                matrix[i][j] = min(matrix[i][j], down + 1, right + 1)
        return matrix


if __name__ == '__main__':
    obj = _542_Solution()
    assert obj.updateMatrix([[0, 0, 0], [0, 1, 0], [0, 0, 0]]) == [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
