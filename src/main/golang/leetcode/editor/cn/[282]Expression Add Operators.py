from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ans = []
        def dfs(idx, path, value, prev):
            if idx == len(num):
                if value == target:
                    ans.append(path)
                return
            for i in range(idx, len(num)):
                if i != idx and num[idx] == '0':
                    break
                cur = int(num[idx:i+1])
                if idx == 0:
                    dfs(i+1, str(cur), cur, cur)
                else:
                    dfs(i+1, path + '+' + str(cur), value + cur, cur)
                    dfs(i+1, path + '-' + str(cur), value - cur, -cur)
                    dfs(i+1, path + '*' + str(cur), value - prev + prev * cur, prev * cur)
        dfs(0, '', 0, 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
