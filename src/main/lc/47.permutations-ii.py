#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#
from typing import List
# @lc code=start


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # nums.sort()
        # ans = []

        # def backtrack(visited: dict, cur: List[int]):
        #     if len(cur) == len(nums):
        #         ans.append(cur[:])
        #         return
        #     pushed = {}
        #     for i in range(len(nums)):
        #         if i in visited:
        #             continue
        #         if nums[i] in pushed:
        #             continue
        #         visited[i] = True
        #         pushed[nums[i]] = True
        #         cur.append(nums[i])
        #         backtrack(visited, cur)
        #         cur.pop()
        #         del visited[i]

        # backtrack(dict(), [])
        # return ans
        from collections import Counter
        ans = []

        def backtrack(cur: List[int], counter):
            if len(cur) == len(nums):
                ans.append(cur)
                return
            for num in counter:
                if counter[num] > 0:
                    counter[num] -= 1
                    backtrack(cur+[num], counter)
                    counter[num] += 1
        backtrack([], Counter(nums))
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.permuteUnique([1]))
    print(s.permuteUnique([1, 1]))
    print(s.permuteUnique([1, 1, 2]))
    print(s.permuteUnique([1, 2, 3]))
