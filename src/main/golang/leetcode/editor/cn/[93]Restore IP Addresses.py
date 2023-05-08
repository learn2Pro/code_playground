from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        ans = []

        def dfs(start, path):
            if len(path) == 4:
                if start == len(s):
                    ans.append('.'.join(path))
                return
            for i in range(start, len(s)):
                if i > start and s[start] == '0':
                    break
                if 0 <= int(s[start:i + 1]) <= 255:
                    path.append(s[start:i + 1])
                    dfs(i + 1, path)
                    path.pop()

        dfs(0, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
