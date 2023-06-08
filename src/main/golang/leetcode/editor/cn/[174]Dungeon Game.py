from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        # dp[i][j]表示从(i,j)到终点所需的最小初始值
        # dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
        m, n = len(dungeon), len(dungeon[0])
        dp = [[-1001] * (n) for _ in range(m)]
        dp[-1][-1] = max(1, 1 - dungeon[-1][-1])
        for i in range(m - 2, -1, -1):
            dp[i][-1] = max(1, dp[i + 1][-1] - dungeon[i][-1])
        for j in range(n - 2, -1, -1):
            dp[-1][j] = max(1, dp[-1][j + 1] - dungeon[-1][j])
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])
        return dp[0][0]
# leetcode submit region end(Prohibit modification and deletion)
