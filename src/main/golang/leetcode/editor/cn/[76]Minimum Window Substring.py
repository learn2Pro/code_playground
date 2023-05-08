# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import Counter
        need = Counter(t)
        window = {}
        left = right = 0
        min_len = 0x7fffffff
        start = 0
        valid = 0
        m, n = len(s), len(t)
        while right < m:
            c = s[right]
            window[c] = window.get(c, 0) + 1
            right += 1
            if c in need and window[c] == need[c]:
                valid += 1
            while valid == len(need):
                if right - left < min_len:
                    start = left
                    min_len = right - left
                d = s[left]
                left += 1
                if d in need and window[d] == need[d]:
                    valid -= 1
                window[d] -= 1
        return s[start:start + min_len] if min_len != 0x7fffffff else ""

# leetcode submit region end(Prohibit modification and deletion)
