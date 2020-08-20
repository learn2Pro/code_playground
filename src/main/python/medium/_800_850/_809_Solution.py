# 809. Expressive Words
from itertools import groupby
from typing import List


class _809_Solution:
    def expressiveWords(self, S: str, words: List[str]) -> int:
        def compare(word) -> bool:
            if S == "" or word == "": return word == S
            i = j = 0
            while i < len(word) and j < len(S):
                c = S[j]
                cnt0, cnt1 = 0, 0
                while j < len(S) and S[j] == c:
                    cnt0 += 1
                    j += 1
                while i < len(word) and word[i] == c:
                    cnt1 += 1
                    i += 1
                if cnt0 < 3 and cnt0 != cnt1 or cnt1 > cnt0 or cnt1 == 0: return False
            return i == len(word) and j == len(S)

        ans = 0
        for word in words:
            if compare(word): ans += 1
        return ans

    def expressiveWords(self, S: str, words: List[str]) -> int:
        def check(word) -> bool:
            j, N, M = 0, len(S), len(word)
            for i in range(N):
                if j < M and S[i] == word[j]:
                    j += 1
                elif S[i - 1:i + 2] != S[i] * 3 != S[i - 2:i + 1]:
                    return False
            return j == M


        ans = 0
        for word in words:
            if check(word): ans += 1
        return ans


'''
"heeellooo"
["hello", "hi", "helo"]
"hlwz"
["hlwz","hhlwz","hllwz","wqarq"]
"hhhhh"
["h","hhh","hhhh","hhhhh",""]
""
["h",""]
""
[]
"h"
[]
"sddadqw"
["adadqw"]
"abcd"
["abc"]
"abc"
["abcd"]
"abcd"
["abc",""]
'''
if __name__ == '__main__':
    tar = _809_Solution()
    assert tar.expressiveWords("heeellooo", ["hello", "hi", "helo"]) == 1
    assert tar.expressiveWords("abcd", ["abc", ""]) == 0
    assert tar.expressiveWords("", ["h", ""]) == 1
    assert tar.expressiveWords("hhhhh", ["h", "hhh", "hhhh", "hhhhh", ""]) == 4
