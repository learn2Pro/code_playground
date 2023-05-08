from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        n = len(candidates)

        def dfs(i: int, current: int, state: List[int]):
            if current == target:
                ans.append(state.copy())
                return
            for x in range(i, n):
                if current + candidates[x] > target:
                    break
                if x > i and candidates[x] == candidates[x - 1]:
                    continue

                state.append(candidates[x])
                # print(state)
                # print(str(x) + " " + str(current + candidates[x]))
                dfs(x + 1, current + candidates[x], state)
                state.pop()

        dfs(0, 0, [])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
