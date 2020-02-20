# 130. Surrounded Regions
from typing import List


class _130_Solution:
    class Dsu:
        def __init__(self, size: int):
            self.size = size
            self.array = [-1] * size

        def find(self, x: int):
            if self.array[x] < 0: return x
            return self.find(self.array[x])

        def union(self, x: int, y: int) -> bool:
            i0, i1 = self.find(x), self.find(y)
            if i0 == i1: return False
            s0, s1 = abs(self.array[i0]), abs(self.array[i1])
            if s0 >= s1:
                self.array[i0] += self.array[i1]
                self.array[i1] = i0
            else:
                self.array[i1] += self.array[i0]
                self.array[i0] = i1
            return True

        def check(self, x: int, y: int) -> bool:
            i0, i1 = self.find(x), self.find(y)
            if i0 == i1: return False
            return True

    def solve(self, board: List[List[str]]) -> None:
        m = len(board)
        if m == 0: return
        n = len(board[0])
        if n == 0: return
        dsu = self.Dsu(m * n + 1)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                        dsu.union(i * n + j, m * n)
                    else:
                        if board[i - 1][j] == 'O':
                            dsu.union((i - 1) * n + j, i * n + j)
                        if board[i + 1][j] == 'O':
                            dsu.union((i + 1) * n + j, i * n + j)
                        if board[i][j - 1] == 'O':
                            dsu.union(i * n + (j - 1), i * n + j)
                        if board[i][j + 1] == 'O':
                            dsu.union(i * n + (j + 1), i * n + j)
        for i in range(m):
            for j in range(n):
                if dsu.check(i * n + j, m * n):
                    board[i][j] = 'X'

    # def solve(self, board: List[List[str]]) -> None:
    #     """
    #     Do not return anything, modify board in-place instead.
    #     """
    #     m = len(board)
    #     if m == 0: return
    #     n = len(board[0])
    #     if n == 0: return
    #     shift = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    #     visited = set()
    #
    #     def dfs(x: int, y: int, track: List[int]) -> bool:
    #         if x < 0 or x >= m or y < 0 or y >= n: return False
    #         visited.add((x, y))
    #         if board[x][y] == 'X': return True
    #         board[x][y] = 'X'
    #         track.append((x, y))
    #         passed = dfs(x + 1, y, track) and dfs(x - 1, y, track) and dfs(x, y + 1, track) and dfs(x, y - 1, track)
    #         if not passed:
    #             while track:
    #                 r0, r1 = track.pop()
    #                 board[r0][r1] = 'O'
    #         return passed
    #
    #     for i in range(m):
    #         for j in range(n):
    #             if (i, j) in visited: continue
    #             if board[i][j] == 'O': dfs(i, j, [])


if __name__ == '__main__':
    instance = _130_Solution
    board = [["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]]
    instance.solve(instance, board)
    assert board == [["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "O", "X", "X"]]
    board = [["X", "O", "O", "X", "X", "X", "O", "X", "O", "O"], ["X", "O", "X", "X", "X", "X", "X", "X", "X", "X"],
             ["X", "X", "X", "X", "O", "X", "X", "X", "X", "X"], ["X", "O", "X", "X", "X", "O", "X", "X", "X", "O"],
             ["O", "X", "X", "X", "O", "X", "O", "X", "O", "X"], ["X", "X", "O", "X", "X", "O", "O", "X", "X", "X"],
             ["O", "X", "X", "O", "O", "X", "O", "X", "X", "O"], ["O", "X", "X", "X", "X", "X", "O", "X", "X", "X"],
             ["X", "O", "O", "X", "X", "O", "X", "X", "O", "O"], ["X", "X", "X", "O", "O", "X", "O", "X", "X", "O"]]
    instance.solve(instance, board)
    assert board == [["X", "O", "O", "X", "X", "X", "O", "X", "O", "O"],
                     ["X", "O", "X", "X", "X", "X", "X", "X", "X", "X"],
                     ["X", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                     ["X", "X", "X", "X", "X", "X", "X", "X", "X", "O"],
                     ["O", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                     ["X", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                     ["O", "X", "X", "X", "X", "X", "X", "X", "X", "O"],
                     ["O", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                     ["X", "X", "X", "X", "X", "X", "X", "X", "O", "O"],
                     ["X", "X", "X", "O", "O", "X", "O", "X", "X", "O"]]
