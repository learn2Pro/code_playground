from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        used = [False] * n

        def dfs(x: int, state: List[int]):
            if x == n:
                ans.append(state.copy())
                return
            for i in range(n):
                if used[i]:
                    continue
                if i > 0 and nums[i] == nums[i - 1] and not used[i-1]:
                    continue

                state.append(nums[i])
                used[i] = True
                dfs(x + 1, state)
                used[i] = False
                state.pop()

        dfs(0, [])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
