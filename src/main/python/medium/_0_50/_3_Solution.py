# 3. Longest Substring Without Repeating Characters
class _3_Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        history = {}
        ans = 0
        for i, c in enumerate(s):
            while c in history:
                del history[s[i - len(history)]]
            history[c] = 1
            ans = max(ans, len(history))
        return ans
