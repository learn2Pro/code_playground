from functools import lru_cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        @lru_cache(None)
        def dfs(s):
            if s.isdigit():
                return [int(s)]
            ans = []
            for i, c in enumerate(s):
                if c in "+-*":
                    left = dfs(s[:i])
                    right = dfs(s[i + 1:])
                    for l in left:
                        for r in right:
                            ans.append(eval(f"{l}{c}{r}"))
            return ans
        return dfs(expression)
# leetcode submit region end(Prohibit modification and deletion)
