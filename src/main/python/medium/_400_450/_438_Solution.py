# 438. Find All Anagrams in a String
from typing import List

'''
"cbaebabacd"
"abc"
""
"abc"
"abc"
"abc"
"abab"
"ab"
"aaaaaaaaaa"
"aaaaaaaaaaaaa"
'''


class _438_Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n_s, n_p, S, P, res = len(s), len(p), 0, 0, []
        if n_p > n_s: return res
        for i in range(n_p):
            S, P = S + hash(s[i]), P + hash(p[i])
        if S == P: res.append(0)
        for i in range(n_p, n_s):
            S += hash(s[i]) - hash(s[i - n_p])
            if S == P: res.append(i - n_p + 1)
        return res

    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or not p: return []
        window, target = [0] * 26, [0] * 26
        for c in p:
            target[ord(c) - ord('a')] += 1
        lo, hi = 0, len(p) - 1
        for i in range(lo, min(len(s), hi)):
            window[ord(s[i]) - ord('a')] += 1
        ans = []
        while hi < len(s):
            window[ord(s[hi]) - ord('a')] += 1
            if target == window:
                ans.append(lo)
            window[ord(s[lo]) - ord('a')] -= 1
            lo += 1
            hi += 1
        return ans


if __name__ == '__main__':
    obj = _438_Solution()
    assert obj.findAnagrams("ababa", "ab") == [0, 1, 2]
