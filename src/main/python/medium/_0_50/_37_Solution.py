# 37. Sudoku Solver
from typing import List


class _37_Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def testAll(row: int, col: int, num: str) -> bool:
            s0 = row // 3 * 3
            s1 = col // 3 * 3
            for i in range(9):
                x0, y0 = i // 3, i % 3
                if board[i][col] == num or board[row][i] == num or board[s0 + x0][s1 + y0] == num: return False
            return True

        def backTrack(i: int, j: int) -> bool:
            for row in range(0, 9):
                for col in range(0, 9):
                    if board[row][col] != '.': continue;
                    for num in range(1, 10):
                        if testAll(row, col, str(num)):
                            board[row][col] = str(num)
                            if backTrack(row, col + 1): return True
                            board[row][col] = '.'
                    return False
            return True

        backTrack(0, 0)


if __name__ == '__main__':
    instance = _37_Solution
    assert instance.solveSudoku(instance, [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    ]) == False
