# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic = {}
        ans = 0
        lo, hi = 0, 0
        while hi < len(s):
            c = s[hi]
            if c not in dic:
                dic[c] = 1
            else:
                dic[c] += 1
            if dic[c] == 1:
                ans = max(ans, len(dic))
            else:
                while lo < hi and dic[c] > 1:
                    dic[s[lo]] -= 1
                    if dic[s[lo]] == 0:
                        del dic[s[lo]]
                    lo += 1
            hi += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
