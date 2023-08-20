#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#
from typing import List
# @lc code=start


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []

        def backtrack(visited: dict, cur: List[int]):
            if len(cur) == len(nums):
                ans.append(cur.copy())
                return
            for i in range(len(nums)):
                if i in visited:
                    continue
                cur.append(nums[i])
                visited[i] = True
                backtrack(visited, cur)
                cur.pop()
                del visited[i]

        backtrack(dict(), [])
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.permute([1]))
    print(s.permute([1, 2]))
    print(s.permute([1, 2, 3]))
