from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        diagonal1 = set()
        diagonal2 = set()
        columns = set()

        def isValid(board: List[str], i: int, j: int):
            if j in columns or i - j in diagonal1 or i + j in diagonal2:
                return False
            return True

        ans = []

        def dfs(board: List[str], row: int):
            if row == n:
                ans.append(board.copy())
                return
            for col in range(n):
                if not isValid(board, row, col):
                    continue
                tmp = board[row]
                board[row] = tmp[:col] + "Q" + tmp[col + 1:]
                columns.add(col)
                diagonal1.add(row - col)
                diagonal2.add(row + col)
                dfs(board, row + 1)
                board[row] = tmp
                columns.remove(col)
                diagonal1.remove(row - col)
                diagonal2.remove(row + col)

        board = ["." * n] * n
        dfs(board, 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
