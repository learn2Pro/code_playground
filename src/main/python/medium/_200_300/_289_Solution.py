# 289. Game of Life
from typing import List

'''
[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
[[0,1,0]]
[[1],[1],[1]]
[[1]]
[[0]]
[]
[[]]
'''
class _289_Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]: return
        m, n = len(board), len(board[0])
        # -1(1->0),-2(0->1)
        shift = [(-1, 0), (-1, -1), (-1, 1), (0, -1), (0, 1), (1, 0), (1, -1), (1, 1)]

        def collectNeighbour(i: int, j: int) -> int:
            size = 0
            for sx, sy in shift:
                px, py = i + sx, j + sy
                if px < 0 or px >= m or py < 0 or py >= n: continue
                if board[px][py] == 1 or board[px][py] == -1:
                    size += 1
            return size

        for i in range(m):
            for j in range(n):
                if board[i][j] == 1:
                    inner = collectNeighbour(i, j)
                    if inner < 2 or inner > 3:
                        board[i][j] = -1
                elif board[i][j] == 0:
                    inner = collectNeighbour(i, j)
                    if inner == 3:
                        board[i][j] = -2
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == -2:
                    board[i][j] = 1

