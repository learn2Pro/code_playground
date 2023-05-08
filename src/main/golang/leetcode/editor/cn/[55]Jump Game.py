from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_dis = 0
        for i, num in enumerate(nums):
            if i > max_dis: return False
            max_dis = max(max_dis, i + num)
        return True
        # n = len(nums)
        #
        # def dfs(target: int):
        #     if target >= n - 1:
        #         return True
        #     for i in range(nums[target], 0, -1):
        #         if dfs(target + i):
        #             return True
        #     return False
        #
        # return dfs(0)
# leetcode submit region end(Prohibit modification and deletion)
