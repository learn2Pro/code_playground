from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        ans = []
        def dfs(i, target, path):
            if target == 0 and len(path) == k:
                ans.append(path)
                return
            if target < 0 or i > 9 or len(path) > k:
                return
            dfs(i + 1, target, path)
            dfs(i + 1, target - i, path + [i])
        dfs(1, n, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
