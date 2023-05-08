from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        n = len(strs)
        if n == 1:
            return strs[0]
        size = len(strs[0])
        for i in range(size+1):
            curr = strs[0][:i]
            match = True
            for j in range(1, n):
                if strs[j][:i] != curr:
                    match = False

            if match:
                res = curr
        return res

# leetcode submit region end(Prohibit modification and deletion)
