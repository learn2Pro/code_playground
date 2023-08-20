# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseVowels(self, s: str) -> str:
        n = len(s)
        i, j = 0, n - 1
        s = list(s)
        while i < j:
            while i < j and s[i] not in 'aeiouAEIOU':
                i += 1
            while i < j and s[j] not in 'aeiouAEIOU':
                j -= 1
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
        return ''.join(s)
# leetcode submit region end(Prohibit modification and deletion)
