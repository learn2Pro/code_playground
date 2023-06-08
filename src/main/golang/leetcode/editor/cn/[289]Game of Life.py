# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        clone = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                clone[i][j] = board[i][j]

        def count(i, j):
            cnt = 0
            for x in range(i - 1, i + 2):
                for y in range(j - 1, j + 2):
                    if x == i and y == j: continue
                    if 0 <= x < m and 0 <= y < n and clone[x][y] == 1:
                        cnt += 1
            return cnt

        for i in range(m):
            for j in range(n):
                cnt = count(i, j)
                if clone[i][j] == 1:
                    if cnt < 2 or cnt > 3:
                        board[i][j] = 0
                else:
                    if cnt == 3:
                        board[i][j] = 1
# leetcode submit region end(Prohibit modification and deletion)
