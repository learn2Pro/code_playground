# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalNQueens(self, n: int) -> int:
        ans = 0

        def dfs(row: int, columns: int, diagonals1: int, diagonals2: int):
            if row == n:
                nonlocal ans
                ans += 1
                return
            available = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2))
            while available:
                pos = available & -available
                available = available & (available - 1)
                dfs(row + 1, columns | pos, (diagonals1 | pos) << 1, (diagonals2 | pos) >> 1)

        dfs(0, 0, 0, 0)
        return ans

        # diagnoles1 = set()
        # diagnoles2 = set()
        # columns = set()
        # ans = 0
        #
        # def isValid(row: int, col: int):
        #     if col in columns or row - col in diagnoles1 or row + col in diagnoles2:
        #         return False
        #     return True
        #
        # def dfs(row: int):
        #     if row == n:
        #         nonlocal ans
        #         ans += 1
        #         return
        #     for col in range(n):
        #         if not isValid(row, col):
        #             continue
        #         columns.add(col)
        #         diagnoles1.add(row - col)
        #         diagnoles2.add(row + col)
        #         dfs(row + 1)
        #         columns.remove(col)
        #         diagnoles1.remove(row - col)
        #         diagnoles2.remove(row + col)
        # dfs(0)
        # return ans

# leetcode submit region end(Prohibit modification and deletion)
