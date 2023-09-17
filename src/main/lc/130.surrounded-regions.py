#
# @lc app=leetcode id=130 lang=python3
#
# [130] Surrounded Regions
#
from typing import List
# @lc code=start


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])

        def dfs(i, j: int, mark):
            if i < 0 or i >= m or j < 0 or j >= n:
                return False
            if board[i][j] == 'X' or board[i][j] == mark:
                return True
            board[i][j] = mark
            flag = True
            for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                flag = dfs(x, y, mark) and flag
            return flag

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    if dfs(i, j, '-'):
                        dfs(i, j, 'X')
                    print(i, j, board)
        for i in range(m):
            for j in range(n):
                if board[i][j] == '-':
                    board[i][j] = 'O'


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    # s.solve([['X', 'X', 'X', 'X'], ['X', 'O', 'O', 'X'],
    #         ['X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X']])
    b = [["O", "X", "O", "O", "O", "X"], ["O", "O", "X", "X", "X", "O"], ["X", "X", "X", "X", "X", "O"], [
        "O", "O", "O", "O", "X", "X"], ["X", "X", "O", "O", "X", "O"], ["O", "O", "X", "X", "X", "X"]]
    s.solve(b)
    print(b)
