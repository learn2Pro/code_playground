# 419. Battleships in a Board
from typing import List


class _419_Solution:
    # use iterative
    def countBattleships(self, board: List[List[str]]) -> int:
        if not board or not board[0]: return 0
        m, n = len(board), len(board[0])
        ans = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == '.': continue
                if i > 0 and board[i - 1][j] == 'X': continue
                if j > 0 and board[i][j - 1] == 'X': continue
                ans += 1
        return ans
    # use dfs
    # def countBattleships(self, board: List[List[str]]) -> int:
    #     if not board or not board[0]: return 0
    #     m, n = len(board), len(board[0])
    #     visited = [[False] * n for _ in range(m)]
    #
    #     def dfs(i: int, j: int, step: int) -> int:
    #         if i >= m or j >= n or board[i][j] == '.':
    #             return 1 if step > 1 else 0
    #         if visited[i][j]:
    #             return 1
    #         visited[i][j], acc = True, 0
    #         for s0, s1 in [(1, 0), (0, 1)]:
    #             x, y = i + s0, j + s1
    #             acc += dfs(x, y, step + 1)
    #         return 1 if acc <= 1 else 0
    #
    #     ans = 0
    #     for i in range(m):
    #         for j in range(n):
    #             if visited[i][j] or board[i][j] == '.': continue
    #             ans += dfs(i, j, 0)
    #     return ans
