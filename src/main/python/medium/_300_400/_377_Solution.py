# 377. Combination Sum IV
from typing import List

'''
[1,2,3]
4
[]
1
[1]
0
[1,2]
0
[1,3,5,7]
10
[1,3,5,7]
1
[3,33,333]
10000
'''
class _377_Solution:
    # use dfs
    def combinationSum4(self, nums: List[int], target: int) -> int:
        if target == 0: return 1
        if not nums: return 0
        path = [-1] * (target + 1)
        path[0] = 1
        nums.sort()

        def dfs(remain: int) -> int:
            if path[remain] >= 0:
                return path[remain]
            ans = 0
            for num in nums:
                if num > remain: break
                ans += dfs(remain - num)
            path[remain] = ans
            return ans

        return dfs(target)

    # use dp
    # def combinationSum4(self, nums: List[int], target: int) -> int:
    #     if target == 0: return 1
    #     if not nums: return 0
    #     dp = [0] * (target + 1)
    #     dp[0] = 1
    #     nums.sort()
    #     for i in range(1, target + 1):
    #         for num in nums:
    #             if num > i: break
    #             dp[i] += dp[i - num]
    #     return dp[target]
