#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#
from typing import List
# @lc code=start


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z'],
        }
        ans = []

        def backtrack(i: int, cur: List[str]):
            if i == len(digits):
                ans.append(''.join(cur))
                return
            for c in mapping[digits[i]]:
                cur.append(c)
                backtrack(i+1, cur)
                cur.pop()

        if not digits:
            return []
        backtrack(0, [])
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.letterCombinations("23"))
    print(s.letterCombinations(""))
