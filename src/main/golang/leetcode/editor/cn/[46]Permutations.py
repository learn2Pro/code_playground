from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # ans = []
        # n = len(nums)
        #
        # def dfs(x: int):
        #     if x == n:
        #         ans.append(nums.copy())
        #         return
        #     for i in range(x, n):
        #         nums[x], nums[i] = nums[i], nums[x]
        #         dfs(x + 1)
        #         nums[x], nums[i] = nums[i], nums[x]
        #
        # dfs(0)
        # return ans
        ans = []
        n = len(nums)
        used = [False] * n

        def dfs(x: int, state: List[int]):
            if x == n:
                ans.append(state.copy())
                return
            for i in range(n):
                if used[i]:
                    continue
                state.append(nums[i])
                used[i] = True
                dfs(x + 1, state)
                used[i] = False
                state.pop()

        dfs(0, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
