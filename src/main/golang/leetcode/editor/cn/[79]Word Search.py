from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(x, y, idx):
            if idx == len(word):
                return True
            if x < 0 or x >= len(board) or y < 0 or y >= len(board[0]):
                return False
            if board[x][y] != word[idx]:
                return False
            tmp = board[x][y]
            board[x][y] = '#'
            res = dfs(x + 1, y, idx + 1) or dfs(x - 1, y, idx + 1) or dfs(x, y + 1, idx + 1) or dfs(x, y - 1, idx + 1)
            board[x][y] = tmp
            return res

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0):
                    return True
        return False
# leetcode submit region end(Prohibit modification and deletion)
