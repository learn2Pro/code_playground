#
# @lc app=leetcode id=40 lang=python3
#
# [40] Combination Sum II
#
from typing import List
# @lc code=start


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []

        def backtrack(start: int, remain: int, curr: List[int]):
            if remain == 0:
                ans.append(curr)
                return
            for i in range(start, len(candidates)):
                if i > start and candidates[i-1] == candidates[i]:
                    continue
                cand = candidates[i]
                if remain >= cand:
                    backtrack(i+1, remain-cand, curr+[cand])

        backtrack(0, target, [])
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    print(s.combinationSum2([2, 5, 2, 1, 2], 5))
