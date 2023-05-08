from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []

        def dfs(start, path):
            if len(path) == k:
                ans.append(path.copy())
                return
            for i in range(start, n + 1):
                path.append(i)
                dfs(i + 1, path)
                path.pop()

        dfs(1, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
