#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#
from typing import List
# @lc code=start


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        for i in range(len(strs[0])+1):
            tmp = strs[0][:i]
            if all(x.startswith(tmp) for x in strs[1:]):
                continue
            else:
                return tmp[:-1]
        return tmp


# @lc code=end

if __name__ == "__main__":
    s = Solution()
    o = s.longestCommonPrefix(['flower', 'flow', 'flight'])
    print(o)
    o = s.longestCommonPrefix(['f', 'flow', 'flight'])
    print(o)
    o = s.longestCommonPrefix(['', 'flow', 'flight'])
    print(o)
    o = s.longestCommonPrefix(['dog', 'racecar', 'car'])
    print(o)
