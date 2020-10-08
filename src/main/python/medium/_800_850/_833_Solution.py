# 833. Find And Replace in String
from typing import List

'''
"abcd"
[0, 2]
["a", "cd"]
["eee", "ffff"]
"abcd"
[0,2]
["ab","ec"]
["eee","ffff"]
""
[]
[]
[]
"ab"
[]
[]
[]
"abc"
[2]
["c"]
["fff"]
"abc"
[2]
["cd"]
["fff"]
"abc"
[0,1]
["abc","d"]
["",""]
"abcd"
[0,3]
["abc","d"]
["","f"]
'''


class _833_Solution:
    def findReplaceString(self, S: str, indexes: List[int], sources: List[str], targets: List[str]) -> str:
        if not indexes: return S
        ans, i = "", 0
        sorted_tuple = sorted(zip(indexes, sources, targets), key=lambda t: t[0])
        for index, source, target in sorted_tuple:
            if i > index: continue
            ans += S[i:index]
            if S[index:index + len(source)] == source:
                ans += target
            else:
                ans += S[index:index + len(source)]
            i = index + len(source)
        ans += S[i:]
        return ans

    def findReplaceString(self, S, indexes, sources, targets):
        S = list(S)
        for i, x, y in sorted(zip(indexes, sources, targets), reverse=True):
            if all(i + k < len(S) and S[i + k] == x[k] for k in range(len(x))):
                S[i:i + len(x)] = list(y)

        return "".join(S)


if __name__ == '__main__':
    tar = _833_Solution()
    assert tar.findReplaceString("vmokgggqzp", [3, 5, 1], ["kg", "ggq", "mo"], ["s", "so", "bfr"]) == "vbfrssozp"
    assert tar.findReplaceString("abcd", [0, 3], ["abc", "d"], ["", "f"]) == "f"
    assert tar.findReplaceString("abc", [0, 1], ["abc", "d"], ["", ""]) == ""
    assert tar.findReplaceString("abcd", [0, 2], ["a", "cd"], ["eee", "ffff"]) == "eeebffff"
    assert tar.findReplaceString("abcd", [0, 2], ["ab", "ec"], ["eee", "ffff"]) == "eeecd"
