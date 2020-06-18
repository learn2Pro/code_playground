# 524. Longest Word in Dictionary through Deleting
from functools import cmp_to_key
from typing import List


class _524_Solution:
    def findLongestWord(self, s: str, d: List[str]) -> str:
        def cmp(k0, k1):
            if len(k0) == len(k1):
                if k0 < k1:
                    return 1
                else:
                    return -1
            else:
                return len(k0) - len(k1)

        def isSubSeq(s0: str, s1: str) -> bool:
            p0 = p1 = 0
            n0, n1 = len(s0), len(s1)
            while p1 < n1 and p0 < n0:
                if s0[p0] == s1[p1]:
                    p0 += 1
                p1 += 1
            return p0 == n0

        d.sort(key=cmp_to_key(cmp), reverse=True)
        for partial in d:
            if isSubSeq(partial, s): return partial
        return ""

    def findLongestWord(self, s: str, d: List[str]) -> str:
        def isSubsequence(x):
            it = iter(s)
            return all(c in it for c in x)
        []+['']
        return min(filter(isSubsequence, d)+[""], key=lambda x: (-len(x), x))


'''
"abpcplea"
["ale","apple","monkey","plea"]
"abpcplea"
["a","b","c"]
"abc"
["abcd","bc","cd"]
"abc"
["def","c","f"]
""
["a",""]
""
["a","b"]
"a"
["",""]
"a"
[]
"bab"
["ba","ab","a","b"]
'''
if __name__ == '__main__':
    obj = _524_Solution()
    assert obj.findLongestWord("bab", ["ba", "ab", "a", "b"]) == "ab"
    assert obj.findLongestWord("abpcplea", ["ale", "apple", "applf", "monkey", "plea"]) == "apple"
