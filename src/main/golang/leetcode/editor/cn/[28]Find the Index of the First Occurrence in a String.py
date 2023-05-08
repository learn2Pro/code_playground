# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # def strStr(self, haystack: str, needle: str) -> int:
    #     try:
    #         return haystack.index(needle)
    #     except:
    #         return -1
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        for i in range(n - m + 1):
            if haystack[i] == needle[0]:
                j = 0
                while j < m:
                    if needle[j] != haystack[i + j]:
                        break
                    j += 1
                if j == m: return i
        return -1

# leetcode submit region end(Prohibit modification and deletion)
