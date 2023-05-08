from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)

        ans = []

        def dfs(current: List[int], remain: int, index: int):
            if remain == 0:
                ans.append(current.copy())
                return
            for i in range(index, n):
                num = candidates[i]
                if num > remain:
                    break
                else:
                    current.append(num)
                    dfs(current, remain - num, i)
                    current.pop()

        dfs([], target, 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
