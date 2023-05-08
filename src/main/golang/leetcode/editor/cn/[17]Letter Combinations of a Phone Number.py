from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.mapping = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z'],
        }

    # def letterCombinations(self, digits: str) -> List[str]:
    #     if len(digits) == 0:
    #         return []
    #     ans = [""]
    #     for c in digits:
    #         tmp = []
    #         for suffix in self.mapping[c]:
    #             for s in ans:
    #                 tmp.append(s + suffix)
    #         ans = tmp
    #     return ans
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        ans = []
        n = len(digits)

        def backtrack(i: int, current: str):
            if i == n:
                ans.append(current)
                return
            for c in self.mapping[digits[i]]:
                backtrack(i + 1, current + c)

        backtrack(0, "")
        return ans
# leetcode submit region end(Prohibit modification and deletion)
