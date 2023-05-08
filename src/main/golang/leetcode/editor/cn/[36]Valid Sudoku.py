from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # def isValid(i: int, j: int, c: str) -> bool:
        #     for x in range(9):
        #         if x != j and board[i][x] == c: return False
        #         if x != i and board[x][j] == c: return False
        #         x0, y0 = i // 3 * 3 + x // 3, j // 3 * 3 + x % 3
        #         if not (x0 == i and y0 == j) and board[x0][y0] == c: return False
        #     return True
        #
        # for i in range(9):
        #     for j in range(9):
        #         if board[i][j] != '.' and not isValid(i, j, board[i][j]):
        #             return False
        # return True
        # row = [[0] * 9] * 9
        # col = [[0] * 9] * 9
        # box = [[0] * 9] * 9
        # for i in range(9):
        #     for j in range(9):
        #         if board[i][j] == '.': continue
        #         idx = int(board[i][j]) - int('1')
        #         if row[i][idx]: return False
        #         if col[j][idx]: return False
        #         if box[i // 3 * 3 + j // 3][idx]: return False
        #
        #         row[i][idx] = 1
        #         col[j][idx] = 1
        #         box[i // 3 * 3 + j // 3][idx] = 1
        # return True
        # 0: row, 1: column, 2: square
        row, col, box = defaultdict(set), defaultdict(set), defaultdict(set)
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in row[i] or board[i][j] in col[j] or board[i][j] in box[
                    i // 3 * 3 + j // 3]:
                    return False
                row[i].add(board[i][j])
                col[j].add(board[i][j])
                box[i // 3 * 3 + j // 3].add(board[i][j])
        return True

# leetcode submit region end(Prohibit modification and deletion)
