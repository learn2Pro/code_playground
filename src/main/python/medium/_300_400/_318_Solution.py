# 318. Maximum Product of Word Lengths
from typing import List

'''
["abcw","baz","foo","bar","xtfn","abcdef"]
["a","ab","abc","d","cd","bcd","abcd"]
["a","ab","abc","d","cd","bcd","abcd"]
'''


class _318_Solution:
    # def maxProduct(self, words: List[str]) -> int:
    #     if len(words) < 2: return 0
    #     d = {}
    #     for w in words:
    #         mask = 0
    #         for c in set(w):
    #             mask |= (1 << (ord(c)-97))
    #         d[mask] = max(d.get(mask, 0), len(w))
    #     return max([d[x]*d[y] for x in d for y in d if not x & y] or [0])

    def maxProduct(self, words: List[str]) -> int:
        if not words: return 0
        ans = 0
        n = len(words)
        values = [0] * n
        for i, word in enumerate(words):
            for c in set(word):
                values[i] |= 1 << (ord(c) - ord('a'))
        for i in range(n):
            for j in range(i + 1, n):
                if values[i] & values[j] == 0: ans = max(ans, len(words[i]) * len(words[j]))
        return ans
