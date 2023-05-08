from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board)
        select = ['1', '2', '3', '4', '5', '6', '7', '8', '9']

        def isValid(i: int, j: int, filled: str):
            for x in range(n):
                if board[x][j] == filled: return False
                if board[i][x] == filled: return False
                if board[i // 3 * 3 + x // 3][j // 3 * 3 + x % 3] == filled: return False
            return True

        def backtrack(location: int):
            if location == n * n:
                return True
            i, j = location // n, location % n
            if board[i][j] != '.':
                return backtrack(location + 1)

            for c in select:
                if not isValid(i, j, c):
                    continue
                board[i][j] = c
                if backtrack(location + 1):
                    return True
                else:
                    board[i][j] = '.'
            return False

        ans = backtrack(0)
        print(board)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
