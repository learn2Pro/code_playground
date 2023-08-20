#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#
from typing import List
# @lc code=start


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []

        def backtrack(start: int, remain: int, cur: List[int]):
            if remain == 0:
                ans.append(cur)
                return
            for i in range(start, len(candidates)):
                candidate = candidates[i]
                if remain >= candidate:
                    backtrack(i, remain-candidate, cur+[candidate])
        backtrack(0, target, [])
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.combinationSum([2, 3, 6, 7], 7))
    print(s.combinationSum([2, 3, 5], 8))
    print(s.combinationSum([2], 1))
